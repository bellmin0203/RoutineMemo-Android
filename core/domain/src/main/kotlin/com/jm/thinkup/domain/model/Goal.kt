package com.jm.thinkup.domain.model

data class Goal(
    val title: String,
    val deadlineDate: Long,
    val createdAt: Long = System.currentTimeMillis()
)
