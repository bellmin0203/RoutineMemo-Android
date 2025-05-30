package com.jm.thinkup.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.jm.designsystem.ThinkUpIcons
import com.jm.thinkup.feature.goal.R as goalR
import com.jm.thinkup.feature.home.R as homeR
import com.jm.thinkup.feature.progress.R as progressR

enum class MainTab(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    @StringRes val iconTextId: Int,
    @StringRes val titleTextId: Int,
    val route: MainTabRoute,
) {
    HOME(
        selectedIcon = ThinkUpIcons.Home,
        unselectedIcon = ThinkUpIcons.HomeBorder,
        iconTextId = homeR.string.feature_home_title,
        titleTextId = homeR.string.feature_home_title,
        route = MainTabRoute.Home,
    ),
    GOAL(
        selectedIcon = ThinkUpIcons.Goal,
        unselectedIcon = ThinkUpIcons.GoalBorder,
        iconTextId = goalR.string.feature_goal_title,
        titleTextId = goalR.string.feature_goal_title,
        route = MainTabRoute.Goal,
    ),
    PROGRESS(
        selectedIcon = ThinkUpIcons.Progress,
        unselectedIcon = ThinkUpIcons.ProgressBorder,
        iconTextId = progressR.string.feature_progress_title,
        titleTextId = progressR.string.feature_progress_title,
        route = MainTabRoute.Progress,
    ),
}