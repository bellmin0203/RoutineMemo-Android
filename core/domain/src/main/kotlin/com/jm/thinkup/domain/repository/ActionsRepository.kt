package com.jm.thinkup.domain.repository

import com.jm.thinkup.domain.model.ActionCompletion
import com.jm.thinkup.domain.model.ActionData
import com.jm.thinkup.domain.model.ActionId
import com.jm.thinkup.domain.model.GoalId
import com.jm.thinkup.domain.model.ObstacleId
import kotlinx.coroutines.flow.Flow
import java.time.Instant

interface ActionsRepository {
    suspend fun createAction(action: ActionData)

    suspend fun getActionsByGoalId(goalId: GoalId): Flow<List<ActionData>>

    suspend fun getActionsByObstacleId(obstacleId: ObstacleId): Flow<List<ActionData>>

    suspend fun updateAction(action: ActionData)

    suspend fun deleteAction(action: ActionData)

    //==============================================================================================
    //  ActionCompletion
    //==============================================================================================
    suspend fun updateActionCompletion(
        actionId: ActionId,
        completionEndDate: Long,
        isCompleted: Boolean
    )

    suspend fun getActionCompletionsByActionId(actionId: ActionId): Flow<List<ActionCompletion>>

    suspend fun getActionCompletionsBeforeDate(
        actionId: ActionId,
        date: Instant
    ): Flow<List<ActionCompletion>>

    suspend fun getCompletedActions(actionId: ActionId): Flow<List<ActionData>>

    suspend fun getCompletedActionsBeforeDate(
        actionId: ActionId,
        date: Instant
    ): Flow<List<ActionData>>

    suspend fun getCompletedActionsByDate(actionId: ActionId, date: Instant): Flow<List<ActionData>>

}