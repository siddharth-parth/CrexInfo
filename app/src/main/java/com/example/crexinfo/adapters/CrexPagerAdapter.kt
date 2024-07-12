package com.example.crexinfo.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.crexinfo.activities.MainActivity
import com.example.crexinfo.fragments.CommentaryFragment
import com.example.crexinfo.fragments.HistoryFragment
import com.example.crexinfo.fragments.InfoFragment
import com.example.crexinfo.fragments.LiveFragment
import com.example.crexinfo.fragments.ScorecardFragment

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