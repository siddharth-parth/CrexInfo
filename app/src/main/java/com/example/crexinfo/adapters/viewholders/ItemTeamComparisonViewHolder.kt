package com.example.crexinfo.adapters.viewholders

import android.content.res.ColorStateList
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.crexinfo.R
import com.example.crexinfo.databinding.ItemTeamComparisonBinding
import com.example.crexinfo.helper.FormatHelper.getTeamLogoUrl
import com.example.crexinfo.helper.ViewHelper
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.TeamComparisonStatsViewData
import com.example.crexinfo.model.viewdatas.TeamComparisonViewData

class ItemTeamComparisonViewHolder(private val binding: ItemTeamComparisonBinding) :
    RecyclerView.ViewHolder(binding.root) {

    // binds data to the view if any
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

    // sets color to the active/inactive button
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

    // sets the data to the team stats text
    private fun setData(stats: TeamComparisonStatsViewData) {
        binding.apply {
            val context = root.context

            tvTeamOne.text = stats.teamOneName
            tvTeamTwo.text = stats.teamTwoName

            // sets team logo to the first team logo image view
            ViewHelper.loadImage(
                ivTeamOne,
                stats.teamOneKey.getTeamLogoUrl(),
                ViewHelper.getShimmer()
            )

            // sets team logo to the second team logo image view
            ViewHelper.loadImage(
                ivTeamTwo,
                stats.teamTwoKey.getTeamLogoUrl(),
                ViewHelper.getShimmer()
            )

            // sets matches player stat data
            layoutMatchesPlayedStat.tvStatTitle.text = context.getString(R.string.matches_played)
            layoutMatchesPlayedStat.tvTeamOneStat.text = stats.teamOneMatches.toString()
            layoutMatchesPlayedStat.tvTeamTwoStat.text = stats.teamTwoMatches.toString()

            // sets win percentage stats data
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

            // sets the color of the win percentage stats text
            if (teamTwoWinPercentage > teamOneWinPercentage) {
                configureStatsText(
                    layoutMatchesWinStat.tvTeamTwoStat,
                    layoutMatchesWinStat.tvTeamOneStat,
                )
            } else {
                configureStatsText(
                    layoutMatchesWinStat.tvTeamOneStat,
                    layoutMatchesWinStat.tvTeamTwoStat,
                )
            }

            // sets team avg score stats data
            val teamOneAvg = stats.teamOneAvgScore.toInt()
            val teamTwoAvg = stats.teamTwoAvgScore.toInt()

            layoutAvgScoreStat.tvStatTitle.text = context.getString(R.string.avg_score)
            layoutAvgScoreStat.tvTeamOneStat.text = teamOneAvg.toString()
            layoutAvgScoreStat.tvTeamTwoStat.text = teamTwoAvg.toString()

            // sets the color of the team avg score stats text
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

            // sets team highest score stats data
            val teamOneHighest = stats.teamOneHighestScore
            val teamTwoHighest = stats.teamTwoHighestScore

            layoutHighestScoreStat.tvStatTitle.text = context.getString(R.string.highest_score)
            layoutHighestScoreStat.tvTeamOneStat.text = teamOneHighest.toString()
            layoutHighestScoreStat.tvTeamTwoStat.text = teamTwoHighest.toString()

            // sets the color of the team highest score stats text
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

            // sets team lowest score stats data
            val teamOneLowest = stats.teamOneLowestScore
            val teamTwoLowest = stats.teamTwoLowestScore

            layoutLowestScoreStat.tvStatTitle.text = context.getString(R.string.lowest_score)
            layoutLowestScoreStat.tvTeamOneStat.text = stats.teamOneLowestScore.toString()
            layoutLowestScoreStat.tvTeamTwoStat.text = stats.teamTwoLowestScore.toString()

            // sets the color of the team lowest score stats text
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
        }
    }

    // updates color of the stat text
    private fun configureStatsText(
        activeText: TextView,
        inActiveText: TextView,
        isActiveRed: Boolean = false,
    ) {
        val context = activeText.context

        if (isActiveRed) {
            // sets [milano_red] to the active text if the color of active text is red
            activeText.setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.milano_red
                )
            )
        } else {
            // sets [la_palma] to the active text if the color of active text is not red
            activeText.setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.la_palma
                )
            )
        }

        // sets [black] to the inactive text
        inActiveText.setTextColor(
            ContextCompat.getColor(
                context,
                R.color.black
            )
        )
    }
}