package com.jm.thinkup.domain.usecase

import com.jm.thinkup.domain.model.GoalId
import com.jm.thinkup.domain.repository.GoalsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetGoalProgressUseCase @Inject constructor(
    private val goalsRepository: GoalsRepository,
) {
    suspend operator fun invoke(goalId: GoalId): Flow<Float> {
        return goalsRepository.getGoalProgress(goalId = goalId)
            .map { (totalActionCount, completedActionCount) ->
                if (totalActionCount == 0) 0f
                else completedActionCount.toFloat() / totalActionCount.toFloat()
            }
    }
}