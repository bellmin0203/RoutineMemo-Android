package com.jm.thinkup.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jm.thinkup.goal.GoalScreen
import com.jm.thinkup.home.HomeScreen
import com.jm.thinkup.progress.ProgressScreen

@Composable
fun MainNavHost(
    mainNavigator: MainNavigator
) {
    NavHost(
        navController = mainNavigator.navController,
        startDestination = mainNavigator.startDestination,
    ) {
        composable<MainTabRoute.Home> {
            HomeScreen()
        }

        composable<MainTabRoute.Goal> {
            GoalScreen()
        }

        composable<MainTabRoute.Progress> {
            ProgressScreen()
        }
    }
}