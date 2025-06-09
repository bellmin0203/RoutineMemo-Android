package com.jm.thinkup.domain.model

import kotlinx.datetime.Clock
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

data class ActionData(
    val id: ActionId,
    val goalId: GoalId,
    val obstacleId: ObstacleId,
    val description: String,
    val isRepeat: Boolean = false,
    val repeatType: RepeatType? = null,
    val startDate: Instant = Clock.System.now(),
    val endDate: Instant,
    val notificationEnabled: Boolean = false,
    val notificationTime: Instant,
    val createdAt: Instant = Clock.System.now(),
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
        val month: kotlinx.datetime.Month
    ) : RepeatType()
}