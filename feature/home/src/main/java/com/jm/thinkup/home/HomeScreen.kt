package com.jm.thinkup.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.AddTask
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jm.designsystem.component.ThinkUpButton
import com.jm.designsystem.component.ThinkUpCard
import com.jm.designsystem.theme.ThemePreviews
import com.jm.designsystem.theme.ThinkUpTheme
import com.jm.designsystem.util.cardDefaultPadding
import com.jm.thinkup.ProgressBarWithText
import com.jm.thinkup.domain.model.Goal
import com.jm.thinkup.feature.home.R
import com.jm.thinkup.home.model.HomeUiIntent
import com.jm.thinkup.home.model.HomeUiState

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.container.uiState.collectAsStateWithLifecycle()

    viewModel.collectSideEffect { sideEffect ->

    }

    HomeScreen(
        uiState = uiState,
        uiIntentHandler = viewModel.rememberUiIntentHandler()
    )
}

@Composable
private fun HomeScreen(
    uiState: HomeUiState,
    uiIntentHandler: (HomeUiIntent) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                uiIntentHandler(HomeUiIntent.AddGoal)
            }) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = null
                )
            }
        }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .cardDefaultPadding(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            OverViewCard()
            TodayActionCard()
            GoalListOverview()
        }
    }
}

@Composable
private fun OverViewCard() {
    ThinkUpCard {
        Column(
            modifier = Modifier.cardDefaultPadding()
        ) {
            Text(text = stringResource(R.string.feature_home_progress_overview))

            Spacer(modifier = Modifier.height(4.dp))

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "75%", modifier = Modifier.align(Alignment.CenterStart))

                ThinkUpButton(
                    onClick = {},
                    text = stringResource(R.string.feature_home_more),
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
        }
    }
}

@Composable
private fun TodayActionCard(
    icon: ImageVector = Icons.Rounded.AddTask,
    text: String = "ABCDEFG",
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(R.string.feature_home_today_action),
                modifier = Modifier.align(Alignment.CenterStart)
            )
            TextButton(
                onClick = {}, modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Text(text = stringResource(R.string.feature_home_view_all))
            }
        }

        ThinkUpCard {
            Box {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .cardDefaultPadding()
                        .align(Alignment.CenterStart)
                ) {
                    Icon(
                        imageVector = icon,
                        modifier = Modifier
                            .background(shape = CircleShape, color = Color.Transparent),
                        contentDescription = null
                    )

                    Spacer(Modifier.width(10.dp))

                    Text(text = text)
                }

                IconButton(
                    onClick = {},
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.MoreVert,
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Composable
private fun GoalListOverview() {
    val goalList: List<Goal> = emptyList()

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "목표", modifier = Modifier.align(Alignment.CenterStart))
            TextButton(
                onClick = {}, modifier = Modifier.align(Alignment.CenterEnd)
            ) { Text(text = "목표 관리") }
        }

        Spacer(Modifier.height(12.dp))

        LazyColumn {
            items(items = goalList, key = { it.id.value }) {
                ThinkUpCard {
                    ProgressBarWithText(
                        title = it.title,
                        progress = 0.5f
                    )
                }
            }
        }
    }
}

@ThemePreviews
@Composable
private fun HomeScreenPreview() {
    ThinkUpTheme {
        HomeScreen(uiState = HomeUiState.Loading, {})
    }
}