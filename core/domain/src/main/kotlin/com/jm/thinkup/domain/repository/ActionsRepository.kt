package com.jm.thinkup.domain.repository

import com.jm.thinkup.domain.model.ActionData
import com.jm.thinkup.domain.model.GoalId
import com.jm.thinkup.domain.model.ObstacleId
import kotlinx.coroutines.flow.Flow

interface ActionsRepository {
    suspend fun createAction(action: ActionData)

    suspend fun getActionsByGoalId(goalId: GoalId): Flow<List<ActionData>>

    suspend fun getActionsByObstacleId(obstacleId: ObstacleId): Flow<List<ActionData>>

    suspend fun updateAction(action: ActionData)

    suspend fun deleteAction(action: ActionData)
}