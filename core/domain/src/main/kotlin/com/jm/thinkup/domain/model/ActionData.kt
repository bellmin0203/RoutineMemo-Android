package com.jm.thinkup.domain.model

import java.time.Instant

data class ActionData(
    val id: ActionId,
    val goalId: GoalId,
    val obstacleId: Long,
    val description: String,
    val isRepeat: Boolean = false,
    val repeatType: Int,
    val endDate: Instant,
    val notificationEnabled: Boolean = false,
    val notificationTime: Long,
    val createdAt: Instant = Instant.now(),
    val extendEndDate: Boolean = false,
)

@JvmInline
value class ActionId(val value: Long)