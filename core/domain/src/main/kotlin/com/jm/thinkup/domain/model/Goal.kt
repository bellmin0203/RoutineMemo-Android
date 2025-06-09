package com.jm.thinkup.domain.model

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant


data class Goal(
    val id: GoalId,
    val title: String,
    val deadlineDate: Instant,
    val createdAt: Instant = Clock.System.now(),
    val isCompleted: Boolean = false,
)

@JvmInline
value class GoalId(val value: Long)