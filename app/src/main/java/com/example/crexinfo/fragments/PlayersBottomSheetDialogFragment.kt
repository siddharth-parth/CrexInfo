package com.example.crexinfo.fragments

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.crexinfo.adapters.PlayersAdapter
import com.example.crexinfo.databinding.PlayersBottomSheetDialogFragmentBinding
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.SectionTitleViewData
import com.example.crexinfo.model.viewdatas.TeamSquadViewData
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayout
import kotlin.math.abs


class PlayersBottomSheetDialogFragment(
    private val currentPos: Int,
    private val teamsSquad: List<TeamSquadViewData>
) :
    BottomSheetDialogFragment() {

    private lateinit var binding: PlayersBottomSheetDialogFragmentBinding

    private lateinit var playersAdapter: PlayersAdapter

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener { dialogInterface ->
            val bottomSheetDialog = dialogInterface as BottomSheetDialog
            setupFullHeight(bottomSheetDialog)
        }
        return dialog
    }

    private fun setupFullHeight(bottomSheetDialog: BottomSheetDialog) {
        val bottomSheet =
            bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
        val behavior: BottomSheetBehavior<*> = BottomSheetBehavior.from(bottomSheet)
        val layoutParams = bottomSheet.layoutParams

        val windowHeight = getWindowHeight()
        if (layoutParams != null) {
            layoutParams.height = windowHeight
        }
        bottomSheet.layoutParams = layoutParams
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun getWindowHeight(): Int {
        // Calculate window height for fullscreen use
        val displayMetrics = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PlayersBottomSheetDialogFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTabLayout()
        setupRecyclerView()
        initClickListeners()
    }

    // setups the tab layout
    private fun setupTabLayout() {
        binding.apply {
            val teamSquadTabs = listOf(tlSquad.newTab(), tlSquad.newTab())

            // add the tabs in the tab layout
            tlSquad.addTab(teamSquadTabs[0].setText(teamsSquad[0].teamShortName))
            tlSquad.addTab(teamSquadTabs[1].setText(teamsSquad[1].teamShortName))

            // selects the item on which user clicked
            tlSquad.selectTab(teamSquadTabs[currentPos])

            // adds a tab selection listener to the tab layout
            tlSquad.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    replaceItemsInRV(tab.position)
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupRecyclerView() {
        binding.apply {
            // gesture detector to enable swipe behaviour in the sheet fragment
            val gestureDetector =
                GestureDetector(requireContext(), object : SimpleOnGestureListener() {
                    override fun onFling(
                        e1: MotionEvent?,
                        e2: MotionEvent,
                        velocityX: Float,
                        velocityY: Float
                    ): Boolean {
                        var result = false
                        try {
                            val e1Y = e1?.y ?: 0f
                            val e2X = e1?.x ?: 0f
                            val diffY = e2.y - e1Y
                            val diffX = e2.x - e2X
                            // detects left or right swipe gesture of user
                            if (abs(diffX.toDouble()) > abs(diffY.toDouble())) {
                                if (abs(diffX.toDouble()) > 100 && abs(velocityX.toDouble()) > 100) {
                                    if (diffX > 0) {
                                        // right swipe
                                        if (tlSquad.selectedTabPosition != 0) {
                                            tlSquad.selectTab(tlSquad.getTabAt(0))
                                        }
                                    } else {
                                        // left swipe
                                        if (tlSquad.selectedTabPosition != 1) {
                                            tlSquad.selectTab(tlSquad.getTabAt(1))
                                        }
                                    }
                                    result = true
                                }
                            }
                        } catch (exception: Exception) {
                            exception.printStackTrace()
                        }
                        return result
                    }
                })

            rvPlayers.setOnTouchListener { _, event ->
                gestureDetector.onTouchEvent(event)
            }

            // attaches the adapter to the recyclerview
            playersAdapter = PlayersAdapter()
            rvPlayers.adapter = playersAdapter
            // sets the data of team 1 to the recycler view by default
            replaceItemsInRV(0)
        }
    }

    // initializes the click listeners
    private fun initClickListeners() {
        binding.ivCross.setOnClickListener {
            this.dismiss()
        }
    }

    // replaces the item in the rv when the selected team is switched
    private fun replaceItemsInRV(position: Int) {
        val items = (teamsSquad[position].playingTeam as List<BaseViewType>).toMutableList()
        items.add(SectionTitleViewData.Builder().title("On Bench").build())
        items.addAll(teamsSquad[position].benchTeam as List<BaseViewType>)
        playersAdapter.replaceItems(items)
    }
}