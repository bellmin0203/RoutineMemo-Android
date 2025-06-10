package com.jm.thinkup.bottomSheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FullBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    paddingTop: Dp = 80.dp,
    content: @Composable (ColumnScope.() -> Unit)
) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        modifier = modifier
            .fillMaxHeight()
            .padding(top = paddingTop),
        sheetState = sheetState,
    ) {
        content()
    }
}

@Preview
@Composable
private fun FullBottomSheetPreview() {
    var showBottomSheet by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = { showBottomSheet = true }
        ) {
            Text("Display full bottom sheet")
        }

        if (showBottomSheet) {
            FullBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
            ) {
                Text("Full bottom sheet")
            }
        }
    }
}