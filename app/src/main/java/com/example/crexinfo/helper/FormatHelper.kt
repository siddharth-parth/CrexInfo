package com.example.crexinfo.helper

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

object FormatHelper {

    // extracts time [01:00 AM] from the timestamp in format [2024-04-13T19:30:00.000Z]
    fun extractTime(timestamp: String): String {
        // Define input and output date formats
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())

        // Set the time zone to IST (Indian Standard Time)
        outputFormat.timeZone = TimeZone.getTimeZone("Asia/Kolkata")

        // Parse input timestamp
        val date = inputFormat.parse(timestamp) ?: ""

        // Format the parsed date to desired time format
        return outputFormat.format(date)
    }

    // extracts abbreviated day and month [14 Apr] from the timestamp in format [2024-04-13T19:30:00.000Z]
    fun extractDayAndMonthAbbreviation(timestamp: String): String {
        // Define input and output date formats
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd MMM", Locale.getDefault())

        // Set the time zone to IST (Indian Standard Time)
        outputFormat.timeZone = TimeZone.getTimeZone("Asia/Kolkata")

        // Parse input timestamp
        val date = inputFormat.parse(timestamp) ?: ""

        // Format the parsed date to desired format
        return outputFormat.format(date)
    }

    // extracts formatted date (Sunday, 14 Apr, 1:00 PM IST) from the timestamp in format [2024-04-13T19:30:00.000Z]
    fun extractFormattedDateTime(timestamp: String): String {
        // Define input and output date formats
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("EEEE, dd MMM, h:mm a z", Locale.getDefault())

        // Set the time zone to IST (Indian Standard Time)
        outputFormat.timeZone = TimeZone.getTimeZone("Asia/Kolkata")

        // Parse input timestamp
        val date = inputFormat.parse(timestamp) ?: ""

        // Format the parsed date to desired format
        return outputFormat.format(date)
    }

    fun parseTeamForm(teamForm: String): List<String> {
        // Initialize an empty mutable list to store the result
        val result = mutableListOf<String>()

        // Regex pattern to match individual characters and numbers
        val regex = Regex("""([WL])(\d+)""")

        // Find all matches in the input pattern
        val matches = regex.findAll(teamForm)

        // Process each match
        matches.forEach { match ->
            val letter = match.groupValues[1]
            val count = match.groupValues[2].toInt()

            // Add the letter count times to the result list
            repeat(count) {
                result.add(letter)
            }
        }

        return result
    }

    // returns the team logo url when called from [teamKey]
    fun String.getTeamLogoUrl(): String {
        return "https://cricketvectors.akamaized.net/Teams/$this.png"
    }

    // returns the team jersey url when called from [teamKey]
    fun String.getTeamJerseyUrl(): String {
        return "https://cricketvectors.akamaized.net/jersey/limited/org/$this.png"
    }

    // returns the series logo url when called from [seriesKey]
    fun String.getSeriesLogoUrl(): String {
        return "https://cricketvectors.akamaized.net/Series/$this.png"
    }

    // returns the player head url when called from [playerKey]
    fun String.getPlayerHeadUrl(): String {
        return "https://cricketvectors.akamaized.net/players/org/$this.png"
    }
}