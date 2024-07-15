package com.example.crexinfo.model

import androidx.annotation.IntDef

const val ITEM_NONE = 0
const val ITEM_MATCH_DETAILS = 1
const val ITEM_MATCH_EVENT = 2
const val ITEM_INFO_SECTION_TITLE = 3
const val ITEM_PLAYING_XI_TEAM = 4
const val ITEM_TEAM_RECENT_MATCHES = 5
const val ITEM_RECENT_MATCH_CARD = 6
const val ITEM_DIVIDER = 7
const val ITEM_SEE_MORE_FIXTURES = 8
const val ITEM_TEAM_COMPARISON = 9
const val ITEM_RESULT_BADGE = 10

@IntDef(
    ITEM_NONE,
    ITEM_MATCH_DETAILS,
    ITEM_MATCH_EVENT,
    ITEM_INFO_SECTION_TITLE,
    ITEM_PLAYING_XI_TEAM,
    ITEM_TEAM_RECENT_MATCHES,
    ITEM_RECENT_MATCH_CARD,
    ITEM_DIVIDER,
    ITEM_SEE_MORE_FIXTURES,
    ITEM_TEAM_COMPARISON,
    ITEM_RESULT_BADGE
)

@Retention(AnnotationRetention.SOURCE)
annotation class ViewType