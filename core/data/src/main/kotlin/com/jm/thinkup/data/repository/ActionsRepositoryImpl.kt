package com.jm.thinkup.data.repository

import com.jm.thinkup.database.dao.ActionDao
import com.jm.thinkup.database.model.toDomainModel
import com.jm.thinkup.database.model.toEntity
import com.jm.thinkup.domain.model.ActionData
import com.jm.thinkup.domain.model.GoalId
import com.jm.thinkup.domain.model.ObstacleId
import com.jm.thinkup.domain.repository.ActionsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

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
}