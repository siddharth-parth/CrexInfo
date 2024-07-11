package com.example.crexinfo

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CrexPagerAdapter(activity: MainActivity) : FragmentStateAdapter(activity) {

    companion object {
        const val CREX_TAB_LAYOUT_ITEMS_COUNT = 5
    }

    override fun getItemCount(): Int {
        return CREX_TAB_LAYOUT_ITEMS_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                InfoFragment()
            }

            1 -> {
                CommentaryFragment()
            }

            2 -> {
                LiveFragment()
            }

            3 -> {
                ScorecardFragment()
            }

            4 -> {
                HistoryFragment()
            }

            else -> {
                throw IndexOutOfBoundsException()
            }
        }
    }
}