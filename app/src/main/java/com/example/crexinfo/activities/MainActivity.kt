package com.example.crexinfo.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.crexinfo.R
import com.example.crexinfo.adapters.CrexPagerAdapter
import com.example.crexinfo.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.dark_background_color)
        setupViews()
    }

    //sets up all the views of the activity
    private fun setupViews() {
        setupViewPager()
    }

    //sets up the view pager
    private fun setupViewPager() {
        binding.apply {
            (vp2Crex.getChildAt(0) as? RecyclerView)?.overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER

            // attaches adapter to the view pager
            vp2Crex.adapter = CrexPagerAdapter(this@MainActivity)

            // attaches the tab layout to the view pager to provide a smooth scrolling between tabs
            TabLayoutMediator(
                tlCrex,
                vp2Crex
            ) { tab: TabLayout.Tab, position: Int ->
                when (position) {
                    // sets the tab title text as per the tab position
                    0 -> {
                        tab.text = getString(R.string.info_fragment_title)
                    }

                    1 -> {
                        tab.text = getString(R.string.commentary_fragment_title)
                    }

                    2 -> {
                        tab.text = getString(R.string.live_fragment_title)
                    }

                    3 -> {
                        tab.text = getString(R.string.scorecard_fragment_title)
                    }

                    4 -> {
                        tab.text = getString(R.string.history_fragment_title)
                    }
                }
            }.attach()
        }
    }
}