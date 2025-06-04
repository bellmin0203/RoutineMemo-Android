package com.jm.designsystem.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.jm.designsystem.theme.ThinkUpTheme
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
        modifier = modifier.fillMaxWidth(),
        trackColor = Color.DarkGray,
        color = color,
    )
}

@Composable
fun rememberSelectedColor(): Color {
    val colors = listOf(
        MaterialTheme.colorScheme.primaryContainer,
        MaterialTheme.colorScheme.secondaryContainer,
        MaterialTheme.colorScheme.tertiaryContainer,
        MaterialTheme.colorScheme.surfaceContainer,
    )
    val selectedColor = colors[Random.nextInt(colors.size)]
    return selectedColor
}

@Preview
@Composable
private fun TuProgressBarPreview() {
    ThinkUpTheme {
        TuProgressBar(progress = 0.5f)
    }
}