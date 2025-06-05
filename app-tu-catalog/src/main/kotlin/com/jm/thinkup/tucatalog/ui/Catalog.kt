package com.jm.thinkup.tucatalog.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jm.designsystem.theme.ThinkUpTheme
import com.jm.thinkup.ProgressBarWithText

@Composable
fun TuCatalog(modifier: Modifier = Modifier) {
    ThinkUpTheme {
        Surface {
            val contentPadding = WindowInsets
                .systemBars
                .add(WindowInsets(left = 16.dp, top = 16.dp, right = 16.dp, bottom = 16.dp))
                .asPaddingValues()
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = contentPadding,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Text(
                        text = "ThinkUp Catalog",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
                item { ProgressBarWithText(title = "Learn Spanish", progress = 0.3f) }
                item { ProgressBarWithText(title = "Learn Spanish", progress = 0.5f) }
                item { ProgressBarWithText(title = "Learn Spanish", progress = 0.7f) }
                item { ProgressBarWithText(title = "Learn Spanish", progress = 0.9f) }
            }
        }
    }
}