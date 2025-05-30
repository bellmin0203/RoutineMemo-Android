package com.jm.thinkup.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.jm.designsystem.theme.ThemePreviews
import com.jm.designsystem.theme.ThinkUpTheme
import com.jm.thinkup.feature.home.R

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(text = stringResource(R.string.feature_home_title))
    }
}

@ThemePreviews
@Composable
private fun HomeScreenPreview() {
    ThinkUpTheme {
        HomeScreen()
    }
}