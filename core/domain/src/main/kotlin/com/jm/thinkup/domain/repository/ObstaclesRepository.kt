package com.jm.thinkup.domain.repository

import com.jm.thinkup.domain.model.GoalId
import com.jm.thinkup.domain.model.Obstacle
import kotlinx.coroutines.flow.Flow

interface ObstaclesRepository {
    suspend fun createObstacle(obstacle: Obstacle)

    suspend fun getObstaclesByGoalId(goalId: GoalId): Flow<List<Obstacle>>

    suspend fun updateObstacle(obstacle: Obstacle)

    suspend fun deleteObstacle(obstacle: Obstacle)
}