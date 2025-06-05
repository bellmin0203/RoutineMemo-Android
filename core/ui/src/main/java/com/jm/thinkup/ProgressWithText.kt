package com.jm.thinkup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jm.designsystem.component.TuProgressBar
import com.jm.designsystem.component.rememberSelectedColor
import com.jm.designsystem.theme.AppTypography
import com.jm.designsystem.theme.ThemePreviews
import com.jm.designsystem.theme.ThinkUpTheme

@Composable
fun ProgressBarWithText(
    title: String,
    modifier: Modifier = Modifier,
    progress: Float,
    color: Color = rememberSelectedColor()
) {
    Column(
        modifier = modifier,
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = title,
                modifier = Modifier.align(Alignment.CenterStart),
                style = AppTypography.labelLarge
            )
            Text(
                text = "${(progress * 100).toInt()}%",
                modifier = Modifier.align(Alignment.CenterEnd),
                style = AppTypography.labelSmall,
                color = color.copy(alpha = 0.8f),
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        TuProgressBar(progress = progress, color = color)
    }
}

@ThemePreviews
@Composable
private fun ProgressBarWithTextPreview() {
    ThinkUpTheme {
        Column {
            ProgressBarWithText(
                progress = 0.3f,
                title = "Learn Spanish"
            )

            ProgressBarWithText(
                progress = 0.5f,
                title = "Learn Spanish"
            )

            ProgressBarWithText(
                progress = 0.7f,
                title = "Learn Spanish"
            )

            ProgressBarWithText(
                progress = 0.9f,
                title = "Learn Spanish"
            )
        }
    }
}