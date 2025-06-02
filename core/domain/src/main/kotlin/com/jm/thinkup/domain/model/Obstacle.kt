package com.jm.thinkup.domain.model

data class Obstacle(
    val id: ObstacleId,
    val goalId: GoalId,
    val description: String
)

@JvmInline
value class ObstacleId(val value: Long)