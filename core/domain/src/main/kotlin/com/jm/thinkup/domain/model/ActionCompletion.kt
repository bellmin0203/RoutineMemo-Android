package com.jm.thinkup.domain.model

import kotlinx.datetime.Instant


data class ActionCompletion(
    val actionId: ActionId,
    val completionEndDate: Instant,
    val isCompleted: Boolean = false,
    val completedAt: Instant? = null
)
