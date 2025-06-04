package com.jm.thinkup.data.repository

import android.util.Log
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
        completionEndDate: Instant,
        isCompleted: Boolean
    ) {
        // Get ActionCompletionEntity by actionId and completionEndDate
        val actionCompletionEntity = actionDao.getActionCompletionByDate(
            actionId = actionId.value,
            date = completionEndDate.toEpochMilli()
        )

        // Update ActionCompletionEntity if found, otherwise print log
        if (actionCompletionEntity != null) {
            val updatedEntity = actionCompletionEntity.copy(isCompleted = isCompleted)
            actionDao.updateActionCompletion(updatedEntity)
        } else {
            Log.w(
                "ActionsRepository",
                "Attempted to update a non-existent action completion. ActionId: ${actionId.value}, Date: $completionEndDate"
            )
        }
    }

    override suspend fun getActionCompletionsByActionId(actionId: ActionId): Flow<List<ActionCompletion>> {
        return actionDao.getActionCompletionsByActionId(actionId = actionId.value)
            .map { actionCompletionEntityList ->
                actionCompletionEntityList.map { actionCompletionEntity ->
                    actionCompletionEntity.toDomainModel()
                }
            }
    }

    override suspend fun getActionCompletionsBeforeDate(
        actionId: ActionId,
        date: Instant
    ): List<ActionCompletion>? {
        return actionDao.getActionCompletionBeforeDate(
            actionId = actionId.value,
            date = date.toEpochMilli()
        )?.map {
            it.toDomainModel()
        }
    }

    override suspend fun getCompletedActions(actionId: ActionId): Flow<List<ActionData>?> {
        return actionDao.getCompletedActions(actionId = actionId.value).map { actionEntityList ->
            actionEntityList?.map { it.toDomainModel() }
        }
    }

    override suspend fun getCompletedActionsBeforeDate(
        actionId: ActionId,
        date: Instant
    ): Flow<List<ActionData>?> {
        return actionDao.getCompletedActionsBeforeDate(
            actionId = actionId.value,
            targetDate = date.toEpochMilli()
        ).map { actionEntityList ->
            actionEntityList?.map { it.toDomainModel() }
        }
    }

    override suspend fun getCompletedActionsByDate(
        actionId: ActionId,
        date: Instant
    ): Flow<List<ActionData>?> {
        return actionDao.getCompletedActionsByDate(
            actionId = actionId.value,
            targetDate = date.toEpochMilli()
        ).map { actionEntityList ->
            actionEntityList?.map { it.toDomainModel() }
        }
    }
}