package com.jm.thinkup.goal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.jm.designsystem.theme.ThemePreviews
import com.jm.designsystem.theme.ThinkUpTheme
import com.jm.thinkup.feature.goal.R

@Composable
fun GoalScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = stringResource(R.string.feature_goal_title))
    }
}

@ThemePreviews
@Composable
private fun GoalPreview() {
    ThinkUpTheme {
        GoalScreen()
    }
}