package com.jm.thinkup.home.model

import androidx.compose.runtime.Immutable
import com.jm.thinkup.base.UiState
import com.jm.thinkup.domain.model.ActionData
import com.jm.thinkup.domain.model.Goal
import kotlinx.collections.immutable.ImmutableList
import kotlinx.datetime.Clock

sealed class HomeUiState : UiState {
    @Immutable
    data object Loading : HomeUiState()

    data class Goals(val goals: ImmutableList<Goal>) : HomeUiState() {
        val goalCount = goals.size
        val completedGoalCount = goals.count { it.isCompleted }
    }

    data class TodayActions(val actions: ImmutableList<ActionData>) : HomeUiState() {
        private val today = Clock.System.now()
    }
}