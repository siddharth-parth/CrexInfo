package com.example.crexinfo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.crexinfo.adapters.InfoPageAdapter
import com.example.crexinfo.adapters.InfoPageAdapterClickListener
import com.example.crexinfo.api.CrexVolley
import com.example.crexinfo.databinding.FragmentInfoBinding
import com.example.crexinfo.helper.FormatHelper.getTeamLogo
import com.example.crexinfo.helper.ViewHelper
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.DividerViewData
import com.example.crexinfo.model.viewdatas.InfoSectionTitleViewData
import com.example.crexinfo.model.viewdatas.MatchInfoViewData
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
        infoRepository = MatchInfoRepository(CrexVolley.getInstance(requireContext()).requestQueue)

        viewModel = ViewModelProvider(
            this,
            InfoViewModelFactory(infoRepository)
        )[InfoViewModel::class.java]

        initRecyclerView()
        observeData()
        fetchData()
    }

    private fun initRecyclerView() {
        binding.rvMatchInfo.apply {
            layoutManager = LinearLayoutManager(requireContext())
            infoAdapter = InfoPageAdapter(this@InfoFragment)
            adapter = infoAdapter
        }
    }

    private fun observeData() {
        viewModel.infoLiveData.observe(viewLifecycleOwner) { response ->
            matchInfoData = response
            setMatchDetails(response)

            infoAdapter.addItems(
                listOf(
                    response.matchDetails,
                    response.matchEvent,
                    InfoSectionTitleViewData.Builder()
                        .title("Playing XI")
                        .build(),
                    response.teamsSquad[0],
                    DividerViewData.Builder().build(),
                    response.teamsSquad[1],
                    DividerViewData.Builder().build(),
                    InfoSectionTitleViewData.Builder()
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

    private fun fetchData() {
        viewModel.fetchInfo()
    }

    private fun setMatchDetails(matchInfo: MatchInfoViewData) {
        binding.apply {
            Glide.with(this@InfoFragment)
                .load(matchInfo.teamOneKey.getTeamLogo())
                .placeholder(ViewHelper.getShimmer())
                .into(ivTeamOne)

            Glide.with(this@InfoFragment)
                .load(matchInfo.teamTwoKey.getTeamLogo())
                .placeholder(ViewHelper.getShimmer())
                .into(ivTeamTwo)

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

        infoAdapter.updateItemIndex(
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
            val seeMoreViewData = getSeeMoreViewFromAdapter()
            val removeItems = (teamRecentMatchesInfo as List<BaseViewType>).toMutableList()
            seeMoreViewData?.let {
                removeItems.add(it)
            }
            infoAdapter.removeItemsAtIndex(position + 1, removeItems)
        } else {
            val addItems = (teamRecentMatchesInfo as List<BaseViewType>).toMutableList()
            addItems.add(SeeMoreFixturesViewData.Builder().build())
            infoAdapter.addItemsAtIndex(position + 1, addItems)
        }
    }

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
        //todo:
    }
}
