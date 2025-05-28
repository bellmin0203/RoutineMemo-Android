package com.jm.thinkup.navigation

import kotlinx.serialization.Serializable

sealed interface MainTabRoute {
    @Serializable
    data object Home : MainTabRoute

    @Serializable
    data object Goal : MainTabRoute

    @Serializable
    data object Progress : MainTabRoute
}