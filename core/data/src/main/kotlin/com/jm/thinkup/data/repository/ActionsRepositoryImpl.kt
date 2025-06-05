package com.jm.thinkup.data.repository

import android.util.Log
import com.jm.common.di.IoDispatcher
import com.jm.thinkup.database.dao.ActionDao
import com.jm.thinkup.database.model.toDomainModel
import com.jm.thinkup.database.model.toEntity
import com.jm.thinkup.domain.model.ActionCompletion
import com.jm.thinkup.domain.model.ActionData
import com.jm.thinkup.domain.model.ActionId
import com.jm.thinkup.domain.model.GoalId
import com.jm.thinkup.domain.model.ObstacleId
import com.jm.thinkup.domain.repository.ActionsRepository
import com.jm.util.mapListToDomainModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import java.time.Instant

class ActionsRepositoryImpl constructor(
    private val actionDao: ActionDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ActionsRepository {
    override suspend fun createAction(action: ActionData) {
        withContext(ioDispatcher) {
            actionDao.insertAction(action = action.toEntity())
        }
    }

    override suspend fun getActionsByGoalId(goalId: GoalId): Flow<List<ActionData>> {
        return actionDao.getActionsByGoalId(goalId = goalId.value)
            .mapListToDomainModel { toDomainModel() }
            .flowOn(ioDispatcher)
    }

    override suspend fun getActionsByObstacleId(obstacleId: ObstacleId): Flow<List<ActionData>> {
        return actionDao.getActionsByObstacleId(obstacleId.value)
            .mapListToDomainModel { toDomainModel() }
            .flowOn(ioDispatcher)
    }

    override suspend fun updateAction(action: ActionData) {
        withContext(ioDispatcher) {
            actionDao.updateAction(action = action.toEntity())
        }
    }

    override suspend fun deleteAction(action: ActionData) {
        withContext(ioDispatcher) {
            actionDao.deleteAction(action = action.toEntity())
        }
    }


    //==============================================================================================
    //  Action Completion
    //==============================================================================================
    override suspend fun updateActionCompletion(
        actionId: ActionId,
        completionEndDate: Instant,
        isCompleted: Boolean
    ): Result<Boolean> {
        return runCatching {
            withContext(ioDispatcher) {
                // Get ActionCompletionEntity by actionId and completionEndDate
                val actionCompletionEntity = actionDao.getActionCompletionByDate(
                    actionId = actionId.value,
                    targetDate = completionEndDate.toEpochMilli()
                )

                // Update ActionCompletionEntity if found, otherwise print log
                if (actionCompletionEntity != null) {
                    val updatedEntity = actionCompletionEntity.copy(isCompleted = isCompleted)
                    actionDao.updateActionCompletion(updatedEntity)
                    true
                } else {
                    Log.w(
                        "ActionsRepository",
                        "Attempted to update a non-existent action completion. ActionId: ${actionId.value}, Date: $completionEndDate"
                    )
                    false
                }
            }
        }
    }

    override suspend fun getActionCompletionsByActionId(actionId: ActionId): Flow<List<ActionCompletion>> {
        return actionDao.getActionCompletionsByActionId(actionId = actionId.value)
            .mapListToDomainModel { toDomainModel() }
            .flowOn(ioDispatcher)
    }

    override suspend fun getActionCompletionsBeforeDate(
        actionId: ActionId,
        date: Instant
    ): List<ActionCompletion> {
        return withContext(ioDispatcher) {
            actionDao.getActionCompletionBeforeDate(
                actionId = actionId.value,
                targetDate = date.toEpochMilli()
            ).mapListToDomainModel { toDomainModel() }
        }
    }

    override suspend fun getCompletedActions(actionId: ActionId): Flow<List<ActionData>> {
        return actionDao.getCompletedActions(actionId = actionId.value)
            .mapListToDomainModel { toDomainModel() }
            .flowOn(ioDispatcher)
    }

    override suspend fun getCompletedActionsBeforeDate(
        actionId: ActionId,
        date: Instant
    ): Flow<List<ActionData>> {
        return actionDao.getCompletedActionsBeforeDate(
            actionId = actionId.value,
            targetDate = date.toEpochMilli()
        ).mapListToDomainModel { toDomainModel() }.flowOn(ioDispatcher)
    }

    override suspend fun getCompletedActionsByDate(
        actionId: ActionId,
        date: Instant
    ): Flow<List<ActionData>> {
        return actionDao.getCompletedActionsByDate(
            actionId = actionId.value,
            targetDate = date.toEpochMilli()
        ).mapListToDomainModel { toDomainModel() }.flowOn(ioDispatcher)
    }
}