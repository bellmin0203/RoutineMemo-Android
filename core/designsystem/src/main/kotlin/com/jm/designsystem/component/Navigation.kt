package com.jm.designsystem.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItemColors
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * 화면 크기별로 Navigation 종류가 대응되는 NavigationSuiteScaffold를 커스텀한 Composable
 */
@Composable
fun TuNavigationSuiteScaffold(
    navigationSuiteItems: TuNavigationSuiteScope.() -> Unit,
    modifier: Modifier = Modifier,
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
    content: @Composable () -> Unit,
) {
    val layoutType = NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(windowAdaptiveInfo)

    val navigationSuiteItemColors = NavigationSuiteItemColors(
        navigationBarItemColors = NavigationBarItemDefaults.colors(
            selectedIconColor = TuNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = TuNavigationDefaults.navigationContentColor(),
            selectedTextColor = TuNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = TuNavigationDefaults.navigationContentColor(),
            indicatorColor = TuNavigationDefaults.navigationIndicatorColor(),
        ),
        navigationRailItemColors = NavigationRailItemDefaults.colors(
            selectedIconColor = TuNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = TuNavigationDefaults.navigationContentColor(),
            selectedTextColor = TuNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = TuNavigationDefaults.navigationContentColor(),
            indicatorColor = TuNavigationDefaults.navigationIndicatorColor(),
        ),
        navigationDrawerItemColors = NavigationDrawerItemDefaults.colors(
            selectedIconColor = TuNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = TuNavigationDefaults.navigationContentColor(),
            selectedTextColor = TuNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = TuNavigationDefaults.navigationContentColor(),
        ),
    )

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            TuNavigationSuiteScope(
                navigationSuiteScope = this,
                navigationSuiteItemColors = navigationSuiteItemColors
            ).run(navigationSuiteItems)
        },
        layoutType = layoutType,
        containerColor = Color.Transparent,
        navigationSuiteColors = NavigationSuiteDefaults.colors(
            navigationBarContentColor = TuNavigationDefaults.navigationContentColor(),
            navigationRailContentColor = Color.Transparent,
            navigationBarContainerColor = TuNavigationDefaults.navigationContainerColor()
        ),
        modifier = modifier
    ) {
        content()
    }
}

class TuNavigationSuiteScope internal constructor(
    private val navigationSuiteScope: NavigationSuiteScope,
    private val navigationSuiteItemColors: NavigationSuiteItemColors,
) {
    fun item(
        selected: Boolean,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        icon: @Composable () -> Unit,
        selectedIcon: @Composable () -> Unit = icon,
        label: @Composable (() -> Unit)? = null,
    ) = navigationSuiteScope.item(
        selected = selected,
        onClick = onClick,
        icon = {
            if (selected) {
                selectedIcon()
            } else {
                icon()
            }
        },
        label = label,
        colors = navigationSuiteItemColors,
        modifier = modifier,
    )
}

object TuNavigationDefaults {
    @Composable
    fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant

    @Composable
    fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer

    @Composable
    fun navigationIndicatorColor() = MaterialTheme.colorScheme.primaryContainer

    @Composable
    fun navigationContainerColor() = MaterialTheme.colorScheme.surfaceVariant
}