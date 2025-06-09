package com.jm.thinkup.domain.repository

import com.jm.thinkup.domain.model.Goal
import com.jm.thinkup.domain.model.GoalId
import kotlinx.coroutines.flow.Flow

interface GoalsRepository {
    suspend fun createGoal(goal: Goal): Boolean

    suspend fun getAllGoals(): Flow<List<Goal>>

    suspend fun getGoalById(id: GoalId): Goal?

    suspend fun updateGoal(goal: Goal)

    suspend fun deleteGoal(goal: Goal)

    suspend fun getGoalProgress(goalId: GoalId): Flow<Pair<Int, Int>>
}