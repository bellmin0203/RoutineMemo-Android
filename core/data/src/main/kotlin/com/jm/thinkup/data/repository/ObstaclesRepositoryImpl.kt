package com.jm.thinkup.data.repository

import com.jm.thinkup.database.dao.ObstacleDao
import com.jm.thinkup.database.model.toDomainModel
import com.jm.thinkup.database.model.toEntity
import com.jm.thinkup.domain.model.GoalId
import com.jm.thinkup.domain.model.Obstacle
import com.jm.thinkup.domain.repository.ObstaclesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ObstaclesRepositoryImpl constructor(
    private val obstaclesDao: ObstacleDao
) : ObstaclesRepository {
    override suspend fun createObstacle(obstacle: Obstacle) {
        obstaclesDao.insertObstacle(obstacle.toEntity())
    }

    override suspend fun getObstaclesByGoalId(goalId: GoalId): Flow<List<Obstacle>> {
        return obstaclesDao.getObstaclesByGoalId(goalId.value).map { obstacleListEntity ->
            obstacleListEntity.map { it.toDomainModel() }
        }
    }

    override suspend fun updateObstacle(obstacle: Obstacle) {
        obstaclesDao.updateObstacle(obstacle.toEntity())
    }

    override suspend fun deleteObstacle(obstacle: Obstacle) {
        obstaclesDao.deleteObstacle(obstacle.toEntity())
    }
}