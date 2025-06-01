package com.jm.thinkup.domain.model

data class ActionData(
    val goalId: Long,
    val obstacleId: Long,
    val description: String,
    val isRepeat: Boolean = false,
    val repeatType: Int,
    val endDate: Long,
    val notificationEnabled: Boolean = false,
    val notificationTime: Long,
    val createdAt: Long = System.currentTimeMillis(),
    val extendEndDate: Boolean = false,
)
