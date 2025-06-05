package com.jm.designsystem.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jm.designsystem.theme.Blue600
import com.jm.designsystem.theme.Green600
import com.jm.designsystem.theme.Orange600
import com.jm.designsystem.theme.Purple600
import com.jm.designsystem.theme.ThemePreviews
import com.jm.designsystem.theme.ThinkUpTheme
import com.jm.designsystem.theme.Yellow600
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TuProgressBar(
    modifier: Modifier = Modifier,
    progress: Float,
    color: Color = rememberSelectedColor()
) {
    var currentProgress by remember { mutableFloatStateOf(0f) }
    val animatedProgress by animateFloatAsState(
        targetValue = currentProgress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )

    LaunchedEffect(Unit) { currentProgress = progress }

    LinearProgressIndicator(
        progress = { animatedProgress },
        modifier = modifier
            .fillMaxWidth()
            .height(6.dp),
        trackColor = Color.DarkGray,
        color = color,
        gapSize = 0.dp,
        drawStopIndicator = {}
    )
}

@Composable
fun rememberSelectedColor(): Color {
    val colors = listOf(
        Purple600,
        Blue600,
        Yellow600,
        Green600,
        Orange600,
    )
    val selectedColor = colors[Random.nextInt(colors.size)]
    return selectedColor
}

@ThemePreviews
@Composable
private fun TuProgressBarPreview() {
    ThinkUpTheme {
        TuProgressBar(progress = 0.5f)
    }
}