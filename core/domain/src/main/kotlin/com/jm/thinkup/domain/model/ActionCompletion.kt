package com.jm.thinkup.domain.model

data class ActionCompletion(
    val actionId: Long,
    val completionDate: Long,
    val isCompleted: Int = 0,
    val completedAt: Long
)
