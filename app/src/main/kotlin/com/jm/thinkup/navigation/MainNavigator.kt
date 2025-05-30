package com.jm.thinkup.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class MainNavigator(val navController: NavHostController) {
    val startDestination = MainTab.HOME.route

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTab: MainTab?
        @Composable get() = MainTab.entries.find { destination ->
            currentDestination?.hasRoute(route = destination.route::class) == true
        }

    fun navigate(tab: MainTab) {
        navController.navigateSingleTopTo(tab.route)
    }

    private fun NavController.navigateSingleTopTo(route: MainTabRoute) {
        this.navigate(route = route) {
            popUpTo(this@navigateSingleTopTo.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}