package com.example.crexinfo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crexinfo.adapters.InfoPageAdapter
import com.example.crexinfo.adapters.InfoPageAdapterClickListener
import com.example.crexinfo.api.CrexVolley
import com.example.crexinfo.databinding.FragmentInfoBinding
import com.example.crexinfo.helper.FormatHelper.getTeamLogoUrl
import com.example.crexinfo.helper.ViewHelper
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.DividerViewData
import com.example.crexinfo.model.viewdatas.MatchInfoViewData
import com.example.crexinfo.model.viewdatas.SectionTitleViewData
import com.example.crexinfo.model.viewdatas.SeeMoreFixturesViewData
import com.example.crexinfo.model.viewdatas.TeamRecentMatchesViewData
import com.example.crexinfo.repository.MatchInfoRepository
import com.example.crexinfo.viewmodel.InfoViewModel
import com.example.crexinfo.viewmodel.InfoViewModelFactory

class InfoFragment : Fragment(), InfoPageAdapterClickListener {

    private lateinit var binding: FragmentInfoBinding

    private lateinit var infoRepository: MatchInfoRepository
    private lateinit var viewModel: InfoViewModel

    private lateinit var infoAdapter: InfoPageAdapter

    private var matchInfoData: MatchInfoViewData? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // initializes the infoRepository
        infoRepository = MatchInfoRepository(CrexVolley.getInstance(requireContext()).requestQueue)

        // initializes the viewModel using the [InfoViewModel]
        viewModel = ViewModelProvider(
            this,
            InfoViewModelFactory(infoRepository)
        )[InfoViewModel::class.java]

        initRecyclerView()
        observeData()
        fetchData()
    }

    // initializes the info recycler view
    private fun initRecyclerView() {
        binding.rvMatchInfo.apply {
            layoutManager = LinearLayoutManager(requireContext())
            infoAdapter = InfoPageAdapter(this@InfoFragment)
            adapter = infoAdapter
        }
    }

    // observes the live data from the view model
    private fun observeData() {
        viewModel.infoLiveData.observe(viewLifecycleOwner) { response ->
            matchInfoData = response
            setMatchDetails(response)

            // adds the items in the recycler view
            infoAdapter.addItems(
                listOf(
                    response.matchDetails,
                    response.matchEvent,
                    SectionTitleViewData.Builder()
                        .title("Playing XI")
                        .build(),
                    response.teamsSquad[0],
                    DividerViewData.Builder().build(),
                    response.teamsSquad[1],
                    DividerViewData.Builder().build(),
                    SectionTitleViewData.Builder()
                        .title("Team Form")
                        .build(),
                    response.teamsRecentMatches[0],
                    DividerViewData.Builder().build(),
                    response.teamsRecentMatches[1],
                    DividerViewData.Builder().build(),
                    response.teamsComparison
                )
            )
        }
    }

    // fetches the data to populate view
    private fun fetchData() {
        viewModel.fetchInfo()
    }

    // sets the basic match details
    private fun setMatchDetails(matchInfo: MatchInfoViewData) {
        binding.apply {
            // sets team logo to the team one logo image view
            ViewHelper.loadImage(
                ivTeamOne,
                matchInfo.teamOneKey.getTeamLogoUrl(),
                ViewHelper.getShimmer()
            )

            // sets team logo to the team two logo image view
            ViewHelper.loadImage(
                ivTeamTwo,
                matchInfo.teamTwoKey.getTeamLogoUrl(),
                ViewHelper.getShimmer()
            )

            tvTeamOne.text = matchInfo.teamOneShortName
            tvTeamTwo.text = matchInfo.teamTwoShortName

            tvMatchTime.text = matchInfo.matchTime
            tvMatchDate.text = matchInfo.matchDate
        }
    }

    override fun onTeamFormExpanded(position: Int, viewData: BaseViewType) {
        val data = viewData as? TeamRecentMatchesViewData ?: return

        val updatedViewData = data.toBuilder()
            .isExpanded(!data.isExpanded)
            .build()

        // updates [isExpanded] in the item in adapter
        infoAdapter.updateItemAtIndex(
            position,
            updatedViewData
        )

        val matchData = matchInfoData ?: return
        val teamInd = if (data.isTeamOne) {
            0
        } else {
            1
        }
        val teamRecentMatchesInfo = (matchData.teamsRecentMatches[teamInd]).teamRecentMatchesInfo

        if (data.isExpanded) {
            // if view is already expanded then it removes the see more view and the match cards to shrink the view
            val seeMoreViewData = getSeeMoreViewFromAdapter()
            val removeItems = (teamRecentMatchesInfo as List<BaseViewType>).toMutableList()
            seeMoreViewData?.let {
                removeItems.add(it)
            }
            infoAdapter.removeItemsAtIndex(position + 1, removeItems)
        } else {
            // if view is not expanded then it adds the see more view and the match cards to expand the view
            val addItems = (teamRecentMatchesInfo as List<BaseViewType>).toMutableList()
            addItems.add(SeeMoreFixturesViewData.Builder().build())
            infoAdapter.addItemsAtIndex(position + 1, addItems)
        }
    }

    // finds and returns the [SeeMoreFixturesViewData] from the recycler view
    private fun getSeeMoreViewFromAdapter(): SeeMoreFixturesViewData? {
        var seeMoreViewData: SeeMoreFixturesViewData? = null
        infoAdapter.items.forEach { item ->
            if (item is SeeMoreFixturesViewData) {
                seeMoreViewData = item
                return@forEach
            }
        }

        return seeMoreViewData
    }

    override fun onTeamPlayingXIOpened(position: Int, viewData: BaseViewType) {
        val teamInd = if (position == 3) {
            0
        } else {
            1
        }
        PlayersBottomSheetDialogFragment(teamInd, (matchInfoData?.teamsSquad) ?: emptyList()).show(
            childFragmentManager,
            "PlayersBottomSheetDialogFragment"
        )
    }
}
