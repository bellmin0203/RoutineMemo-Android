package com.jm.thinkup.data.repository

import com.jm.thinkup.database.dao.ActionDao
import com.jm.thinkup.database.model.toDomainModel
import com.jm.thinkup.database.model.toEntity
import com.jm.thinkup.domain.model.ActionCompletion
import com.jm.thinkup.domain.model.ActionData
import com.jm.thinkup.domain.model.ActionId
import com.jm.thinkup.domain.model.GoalId
import com.jm.thinkup.domain.model.ObstacleId
import com.jm.thinkup.domain.repository.ActionsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.Instant

class ActionsRepositoryImpl constructor(
    private val actionDao: ActionDao
) : ActionsRepository {
    override suspend fun createAction(action: ActionData) {
        actionDao.insertAction(action = action.toEntity())
    }

    override suspend fun getActionsByGoalId(goalId: GoalId): Flow<List<ActionData>> {
        return actionDao.getActionsByGoalId(goalId = goalId.value).map { actionEntityList ->
            actionEntityList.map { actionEntity ->
                actionEntity.toDomainModel()
            }
        }
    }

    override suspend fun getActionsByObstacleId(obstacleId: ObstacleId): Flow<List<ActionData>> {
        return actionDao.getActionsByObstacleId(obstacleId.value).map { obstacleEntityList ->
            obstacleEntityList.map { obstacleEntity ->
                obstacleEntity.toDomainModel()
            }
        }
    }

    override suspend fun updateAction(action: ActionData) {
        actionDao.updateAction(action = action.toEntity())
    }

    override suspend fun deleteAction(action: ActionData) {
        actionDao.deleteAction(action = action.toEntity())
    }


    //==============================================================================================
    //  Action Completion
    //==============================================================================================
    override suspend fun updateActionCompletion(
        actionId: ActionId,
        completionEndDate: Long,
        isCompleted: Boolean
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun getActionCompletionsByActionId(actionId: ActionId): Flow<List<ActionCompletion>> {
        TODO("Not yet implemented")
    }

    override suspend fun getActionCompletionsBeforeDate(
        actionId: ActionId,
        date: Instant
    ): Flow<List<ActionCompletion>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCompletedActions(actionId: ActionId): Flow<List<ActionData>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCompletedActionsBeforeDate(
        actionId: ActionId,
        date: Instant
    ): Flow<List<ActionData>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCompletedActionsByDate(
        actionId: ActionId,
        date: Instant
    ): Flow<List<ActionData>> {
        TODO("Not yet implemented")
    }
}