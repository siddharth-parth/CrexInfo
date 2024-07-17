package com.example.crexinfo.adapters.viewholders

import android.content.res.ColorStateList
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.crexinfo.R
import com.example.crexinfo.databinding.ItemTeamComparisonBinding
import com.example.crexinfo.helper.FormatHelper.getTeamLogo
import com.example.crexinfo.helper.ViewHelper
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.TeamComparisonStatsViewData
import com.example.crexinfo.model.viewdatas.TeamComparisonViewData

class ItemTeamComparisonViewHolder(private val binding: ItemTeamComparisonBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(viewData: BaseViewType) {
        binding.apply {
            val data = viewData as? TeamComparisonViewData ?: return@apply
            var isOverallTabSelected = true

            btnOverall.setOnClickListener {
                if (isOverallTabSelected) {
                    return@setOnClickListener
                }

                isOverallTabSelected = true
                configureButton(btnOverall, btnVenue)
                setData(data.overallStats)
            }

            btnVenue.setOnClickListener {
                if (!isOverallTabSelected) {
                    return@setOnClickListener
                }

                isOverallTabSelected = false
                configureButton(btnVenue, btnOverall)
                setData(data.onVenueStats)
            }

            val stats = if (isOverallTabSelected) {
                data.overallStats
            } else {
                data.onVenueStats
            }

            setData(stats)
        }
    }

    private fun configureButton(
        activeButton: AppCompatButton,
        inActiveButton: AppCompatButton
    ) {
        val context = activeButton.context

        activeButton.setBackgroundResource(R.drawable.bg_rounded_corners_8dp)
        activeButton.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.venice_blue))
        activeButton.setTextColor(ContextCompat.getColor(context, R.color.white))

        inActiveButton.setBackgroundResource(R.drawable.bg_rounded_corners_8dp_stoke_1dp)
        inActiveButton.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(context, R.color.white))
        inActiveButton.setTextColor(ContextCompat.getColor(context, R.color.tundora))
    }

    private fun setData(stats: TeamComparisonStatsViewData) {
        binding.apply {
            val context = root.context

            tvTeamOne.text = stats.teamOneName
            tvTeamTwo.text = stats.teamTwoName

            Glide.with(context)
                .load(stats.teamOneKey.getTeamLogo())
                .placeholder(ViewHelper.getShimmer())
                .into(ivTeamOne)

            Glide.with(context)
                .load(stats.teamTwoKey.getTeamLogo())
                .placeholder(ViewHelper.getShimmer())
                .into(ivTeamTwo)

            layoutMatchesPlayedStat.tvStatTitle.text = context.getString(R.string.matches_played)
            layoutMatchesPlayedStat.tvTeamOneStat.text = stats.teamOneMatches.toString()
            layoutMatchesPlayedStat.tvTeamTwoStat.text = stats.teamTwoMatches.toString()

            val teamOneWinPercentage =
                ((stats.teamOneMatchesWon * 1.0f / stats.teamOneMatches) * 100).toInt()
            val teamTwoWinPercentage =
                ((stats.teamTwoMatchesWon * 1.0f / stats.teamTwoMatches) * 100).toInt()

            layoutMatchesWinStat.tvStatTitle.text = context.getString(R.string.win)
            layoutMatchesWinStat.tvTeamOneStat.text = context.getString(
                R.string.win_percentage,
                teamOneWinPercentage,
            )
            layoutMatchesWinStat.tvTeamTwoStat.text = context.getString(
                R.string.win_percentage,
                teamTwoWinPercentage,
            )

            if (teamTwoWinPercentage > teamOneWinPercentage) {
                configureStatsText(
                    layoutMatchesWinStat.tvTeamTwoStat,
                    layoutMatchesWinStat.tvTeamOneStat,
                    from = 0
                )
            } else {
                configureStatsText(
                    layoutMatchesWinStat.tvTeamOneStat,
                    layoutMatchesWinStat.tvTeamTwoStat,
                    from = 0
                )
            }

            val teamOneAvg = stats.teamOneAvgScore.toInt()
            val teamTwoAvg = stats.teamTwoAvgScore.toInt()

            if (teamTwoAvg > teamOneAvg) {
                configureStatsText(
                    layoutAvgScoreStat.tvTeamTwoStat,
                    layoutAvgScoreStat.tvTeamOneStat
                )
            } else {
                configureStatsText(
                    layoutAvgScoreStat.tvTeamOneStat,
                    layoutAvgScoreStat.tvTeamTwoStat
                )
            }
            layoutAvgScoreStat.tvStatTitle.text = context.getString(R.string.avg_score)
            layoutAvgScoreStat.tvTeamOneStat.text = teamOneAvg.toString()
            layoutAvgScoreStat.tvTeamTwoStat.text = teamTwoAvg.toString()

            val teamOneHighest = stats.teamOneHighestScore
            val teamTwoHighest = stats.teamTwoHighestScore

            if (teamTwoHighest > teamOneHighest) {
                configureStatsText(
                    layoutHighestScoreStat.tvTeamTwoStat,
                    layoutHighestScoreStat.tvTeamOneStat
                )
            } else {
                configureStatsText(
                    layoutHighestScoreStat.tvTeamOneStat,
                    layoutHighestScoreStat.tvTeamTwoStat
                )
            }
            layoutHighestScoreStat.tvStatTitle.text = context.getString(R.string.highest_score)
            layoutHighestScoreStat.tvTeamOneStat.text = teamOneHighest.toString()
            layoutHighestScoreStat.tvTeamTwoStat.text = teamTwoHighest.toString()

            val teamOneLowest = stats.teamOneLowestScore
            val teamTwoLowest = stats.teamTwoLowestScore

            if (teamOneLowest > teamTwoLowest) {
                configureStatsText(
                    layoutLowestScoreStat.tvTeamTwoStat,
                    layoutLowestScoreStat.tvTeamOneStat,
                    isActiveRed = true
                )
            } else {
                configureStatsText(
                    layoutLowestScoreStat.tvTeamOneStat,
                    layoutLowestScoreStat.tvTeamTwoStat,
                    isActiveRed = true
                )
            }
            layoutLowestScoreStat.tvStatTitle.text = context.getString(R.string.lowest_score)
            layoutLowestScoreStat.tvTeamOneStat.text = stats.teamOneLowestScore.toString()
            layoutLowestScoreStat.tvTeamTwoStat.text = stats.teamTwoLowestScore.toString()
        }
    }

    private fun configureStatsText(
        activeText: TextView,
        inActiveText: TextView,
        isActiveRed: Boolean = false,
        from: Int = 1
    ) {
        val context = activeText.context

        if (isActiveRed) {
            activeText.setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.milano_red
                )
            )
        } else {
            activeText.setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.la_palma
                )
            )
        }

        inActiveText.setTextColor(
            ContextCompat.getColor(
                context,
                R.color.black
            )
        )
    }
}