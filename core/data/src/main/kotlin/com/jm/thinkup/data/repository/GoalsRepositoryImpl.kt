package com.jm.thinkup.data.repository

import com.jm.thinkup.database.dao.GoalDao
import com.jm.thinkup.database.model.toDomainModel
import com.jm.thinkup.database.model.toEntity
import com.jm.thinkup.domain.model.Goal
import com.jm.thinkup.domain.model.GoalId
import com.jm.thinkup.domain.repository.GoalsRepository
import com.jm.util.mapListToDomainModel
import kotlinx.coroutines.flow.Flow

class GoalsRepositoryImpl constructor(
    private val goalDao: GoalDao
) : GoalsRepository {
    override suspend fun createGoal(goal: Goal): Boolean {
        val rowId = goalDao.insertGoal(goal = goal.toEntity())
        return rowId > 0
    }

    override suspend fun getAllGoals(): Flow<List<Goal>> {
        return goalDao.getAllGoals().mapListToDomainModel { toDomainModel() }
    }

    override suspend fun getGoalById(id: GoalId): Goal? {
        return goalDao.getGoalById(id.value)?.toDomainModel()
    }

    override suspend fun updateGoal(goal: Goal) {
        goalDao.updateGoal(goal = goal.toEntity())
    }

    override suspend fun deleteGoal(goal: Goal) {
        goalDao.deleteGoal(goal.toEntity())
    }
}