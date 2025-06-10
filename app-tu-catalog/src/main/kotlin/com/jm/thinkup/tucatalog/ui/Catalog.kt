package com.jm.thinkup.tucatalog.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jm.designsystem.theme.ThinkUpTheme
import com.jm.thinkup.ProgressBarWithText
import com.jm.thinkup.bottomSheet.FullBottomSheet
import com.jm.thinkup.bottomSheet.HalfBottomSheet

@Composable
fun TuCatalog(modifier: Modifier = Modifier) {
    ThinkUpTheme {
        Surface {
            val contentPadding = WindowInsets
                .systemBars
                .add(WindowInsets(left = 16.dp, top = 16.dp, right = 16.dp, bottom = 16.dp))
                .asPaddingValues()

            var showFullBottomSheet by remember { mutableStateOf(false) }
            var showHalfBottomSheet by remember { mutableStateOf(false) }

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
                item {
                    Button(onClick = {
                        showFullBottomSheet = true
                    }) { Text("Show Full Bottom Sheet") }
                }
                item {
                    Button(onClick = {
                        showHalfBottomSheet = true
                    }) { Text("Show Half Bottom Sheet") }
                }
            }

            if (showFullBottomSheet) {
                FullBottomSheetScreen(onDismissRequest = { showFullBottomSheet = false })
            }

            if (showHalfBottomSheet) {
                HalfBottomSheetScreen(onDismissRequest = { showHalfBottomSheet = false })
            }
        }
    }
}

@Composable
private fun FullBottomSheetScreen(
    onDismissRequest: () -> Unit,
) {
    FullBottomSheet(
        onDismissRequest = onDismissRequest,
    ) {
        Text("Full bottom sheet")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HalfBottomSheetScreen(
    onDismissRequest: () -> Unit,
) {
    HalfBottomSheet(
        onDismissRequest = onDismissRequest,
    ) {
        Text("Half bottom sheet")
    }
}