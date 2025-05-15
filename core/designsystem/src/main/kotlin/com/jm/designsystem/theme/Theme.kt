package com.jm.designsystem.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// Light ColorScheme
val LightColorScheme = lightColorScheme(
    primary = Green500,
    onPrimary = White,
    primaryContainer = Green100,
    onPrimaryContainer = Green800,

    secondary = Blue300,
    onSecondary = White,
    secondaryContainer = Blue50,
    onSecondaryContainer = Blue800,

    tertiary = Yellow300,
    onTertiary = Black,
    tertiaryContainer = Yellow100,
    onTertiaryContainer = Yellow800,

    background = Grey50,
    onBackground = Grey800,

    surface = White,
    onSurface = Grey800,
    surfaceVariant = Grey200,
    onSurfaceVariant = Grey600,

    error = Red500,
    onError = White,
    errorContainer = Red100,
    onErrorContainer = Red900,

    outline = Grey300,
    outlineVariant = Grey200,
    scrim = Black,

    inverseSurface = Grey800,
    inverseOnSurface = Grey100,
    inversePrimary = Green600,
)

// Dark ColorScheme
val DarkColorScheme = darkColorScheme(
    primary = Green700,
    onPrimary = Black,
    primaryContainer = Green600,
    onPrimaryContainer = White,

    secondary = Blue700,
    onSecondary = White,
    secondaryContainer = Blue800,
    onSecondaryContainer = White,

    tertiary = Yellow700,
    onTertiary = White,
    tertiaryContainer = Yellow800,
    onTertiaryContainer = Yellow100,

    background = Grey900,
    onBackground = Grey100,

    surface = Grey800,
    onSurface = Grey100,
    surfaceVariant = Grey600,
    onSurfaceVariant = Grey200,

    error = Red500,
    onError = White,
    errorContainer = Red300,
    onErrorContainer = Red900,

    outline = Grey300,
    outlineVariant = Grey600,
    scrim = Black,

    inverseSurface = Grey100,
    inverseOnSurface = Grey900,
    inversePrimary = Green300,
)


@Composable
fun RoutineMemoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}