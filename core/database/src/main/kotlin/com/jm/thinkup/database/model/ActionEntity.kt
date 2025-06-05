package com.jm.thinkup.database.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.jm.thinkup.domain.model.ActionData
import com.jm.thinkup.domain.model.ActionId
import com.jm.thinkup.domain.model.GoalId
import com.jm.thinkup.domain.model.ObstacleId
import kotlinx.serialization.json.Json
import java.time.Instant

@Entity(
    tableName = "action_tb",
    foreignKeys = [
        ForeignKey(
            entity = GoalEntity::class,
            parentColumns = ["id"],
            childColumns = ["goalId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ObstacleEntity::class,
            parentColumns = ["id"],
            childColumns = ["obstacleId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["goalId"]),      // goalId에 대한 인덱스
        Index(value = ["obstacleId"])   // obstacleId에 대한 인덱스
    ]
)
data class ActionEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val goalId: Long,
    val obstacleId: Long,
    val description: String,
    val isRepeat: Boolean = false,
    val repeatType: String? = null,
    val endDate: Long,
    val notificationEnabled: Boolean = false,
    val notificationTime: Long,
    val createdAt: Long = System.currentTimeMillis(),
    val extendEndDate: Boolean = false,
)

fun ActionEntity.toDomainModel(): ActionData =
    ActionData(
        id = ActionId(id),
        goalId = GoalId(goalId),
        obstacleId = ObstacleId(obstacleId),
        description = description,
        isRepeat = isRepeat,
        repeatType = repeatType?.let { Json.decodeFromString(it) },
        endDate = Instant.ofEpochMilli(endDate),
        notificationEnabled = notificationEnabled,
        notificationTime = Instant.ofEpochMilli(notificationTime),
        createdAt = Instant.ofEpochMilli(createdAt),
        extendEndDate = extendEndDate,
    )

fun ActionData.toEntity(): ActionEntity =
    ActionEntity(
        id = id.value,
        goalId = goalId.value,
        obstacleId = obstacleId.value,
        description = description,
        isRepeat = isRepeat,
        repeatType = repeatType?.let { Json.encodeToString(it) },
        endDate = endDate.toEpochMilli(),
        notificationEnabled = notificationEnabled,
        notificationTime = notificationTime.toEpochMilli(),
        createdAt = createdAt.toEpochMilli(),
        extendEndDate = extendEndDate,
    )

