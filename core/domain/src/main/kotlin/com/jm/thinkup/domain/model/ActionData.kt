package com.jm.thinkup.domain.model

import kotlinx.serialization.Serializable
import java.time.DayOfWeek
import java.time.Instant

data class ActionData(
    val id: ActionId,
    val goalId: GoalId,
    val obstacleId: ObstacleId,
    val description: String,
    val isRepeat: Boolean = false,
    val repeatType: RepeatType? = null,
    val startDate: Instant = Instant.now(),
    val endDate: Instant,
    val notificationEnabled: Boolean = false,
    val notificationTime: Instant,
    val createdAt: Instant = Instant.now(),
    val extendEndDate: Boolean = false,
)

@JvmInline
value class ActionId(val value: Long)

@Serializable
sealed class RepeatType {
    abstract val intervalValue: Int

    @Serializable
    data class Minute(override val intervalValue: Int) : RepeatType()
    @Serializable
    data class Hour(override val intervalValue: Int) : RepeatType()
    @Serializable
    data class Day(override val intervalValue: Int) : RepeatType()
    @Serializable
    data class Week(
        override val intervalValue: Int,
        val dayOfWeek: DayOfWeek
    ) : RepeatType()

    @Serializable
    data class Month(
        override val intervalValue: Int,
        val weekOrdinal: Int,
        val dayOfWeek: DayOfWeek
    ) : RepeatType()

    @Serializable
    data class Year(
        override val intervalValue: Int,
        val weekOrdinal: Int,
        val dayOfWeek: DayOfWeek,
        val month: java.time.Month
    ) : RepeatType()
}