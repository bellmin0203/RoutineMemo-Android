package com.jm.thinkup.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.jm.designsystem.component.TuNavigationSuiteScaffold
import com.jm.designsystem.theme.ThemePreviews
import com.jm.designsystem.theme.ThinkUpTheme
import com.jm.thinkup.navigation.MainNavHost
import com.jm.thinkup.navigation.MainNavigator
import com.jm.thinkup.navigation.MainTab
import com.jm.thinkup.navigation.rememberMainNavigator

const val TAG = "JM_LOG"

@Composable
fun ThinkUpApp(
    navigator: MainNavigator = rememberMainNavigator(),
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
) {
    val currentTab = navigator.currentTab

    ThinkUpTheme {
        TuNavigationSuiteScaffold(
            navigationSuiteItems = {
                MainTab.entries.forEach { destination ->
                    val selected = destination == currentTab

                    item(
                        selected = selected,
                        onClick = { navigator.navigate(destination) },
                        modifier = Modifier,
                        icon = {
                            Icon(
                                imageVector = destination.unselectedIcon,
                                contentDescription = null
                            )
                        },
                        selectedIcon = {
                            Icon(
                                imageVector = destination.selectedIcon,
                                contentDescription = null
                            )
                        },
                        label = { Text(stringResource(destination.titleTextId)) },
                    )
                }
            },
            windowAdaptiveInfo = windowAdaptiveInfo,
        ) {
            Scaffold(
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onBackground,
            ) { padding ->
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(padding)
                ) {
                    MainNavHost(
                        mainNavigator = navigator
                    )
                }
            }
        }
    }
}

@ThemePreviews
@Composable
private fun ThinkUpAppPreview() {
    ThinkUpApp()
}