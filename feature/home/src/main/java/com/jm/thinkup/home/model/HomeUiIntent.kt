package com.jm.thinkup.home.model

import com.jm.thinkup.base.UiIntent

sealed class HomeUiIntent : UiIntent {
    data object AddGoal : HomeUiIntent()
}