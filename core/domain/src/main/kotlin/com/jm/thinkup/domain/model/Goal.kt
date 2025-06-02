package com.jm.thinkup.domain.model

import java.time.Instant

data class Goal(
    val id: GoalId,
    val title: String,
    val deadlineDate: Instant,
    val createdAt: Instant = Instant.now()
)

@JvmInline
value class GoalId(val value: Long)