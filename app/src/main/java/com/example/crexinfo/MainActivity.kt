package com.example.crexinfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
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
            vp2Crex.adapter = CrexPagerAdapter(this@MainActivity)

            TabLayoutMediator(
                tlCrex,
                vp2Crex
            ) { tab: TabLayout.Tab, position: Int ->
                when (position) {
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