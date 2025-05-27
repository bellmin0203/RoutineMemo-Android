package com.jm.designsystem.theme

import android.content.res.Configuration
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, name = "Light theme")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark theme")
annotation class ThemePreviews

val LightColorScheme = lightColorScheme(
    primary = CoffeeBrown500,
    onPrimary = White,
    primaryContainer = CoffeeBrown300,
    onPrimaryContainer = CoffeeBrown700,

    secondary = LatteBeige500,
    onSecondary = Black,
    secondaryContainer = LatteBeige300,
    onSecondaryContainer = LatteBeige700,

    tertiary = Espresso500,
    onTertiary = White,
    tertiaryContainer = Espresso300,
    onTertiaryContainer = Espresso700,

    background = Grey50,
    onBackground = CoffeeBrown700,

    surface = White,
    onSurface = CoffeeBrown700,
    surfaceVariant = Grey100,
    onSurfaceVariant = Grey800,

    error = Red500,
    onError = White,
    errorContainer = Red100,
    onErrorContainer = Red900,

    outline = Grey300,
    outlineVariant = Grey100,
    scrim = Black,

    inverseSurface = Grey800,
    inverseOnSurface = Grey100,
    inversePrimary = CoffeeBrown700,
)

val DarkColorScheme = darkColorScheme(
    primary = CoffeeBrown300,
    onPrimary = Black,
    primaryContainer = CoffeeBrown500,
    onPrimaryContainer = White,

    secondary = LatteBeige300,
    onSecondary = Black,
    secondaryContainer = LatteBeige500,
    onSecondaryContainer = White,

    tertiary = Espresso300,
    onTertiary = Black,
    tertiaryContainer = Espresso500,
    onTertiaryContainer = White,

    background = Grey800,
    onBackground = Grey100,

    surface = CoffeeBrown700,
    onSurface = LatteBeige300,
    surfaceVariant = Grey600,
    onSurfaceVariant = White,

    error = Red500,
    onError = White,
    errorContainer = Red900,
    onErrorContainer = White,

    outline = Grey300,
    outlineVariant = Grey600,
    scrim = Black,

    inverseSurface = Grey100,
    inverseOnSurface = Grey800,
    inversePrimary = CoffeeBrown300,
)


@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
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