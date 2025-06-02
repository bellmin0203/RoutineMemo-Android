package com.jm.thinkup.database.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.jm.thinkup.domain.model.ActionData
import com.jm.thinkup.domain.model.ActionId
import com.jm.thinkup.domain.model.GoalId
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
    ]
)
data class ActionEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
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

fun ActionEntity.toDomainModel(): ActionData =
    ActionData(
        id = ActionId(id),
        goalId = GoalId(goalId),
        obstacleId = obstacleId,
        description = description,
        isRepeat = isRepeat,
        repeatType = repeatType,
        endDate = Instant.ofEpochMilli(endDate),
        notificationEnabled = notificationEnabled,
        notificationTime = notificationTime,
        createdAt = Instant.ofEpochMilli(createdAt),
        extendEndDate = extendEndDate,
    )

fun ActionData.toEntity(): ActionEntity =
    ActionEntity(
        id = id.value,
        goalId = goalId.value,
        obstacleId = obstacleId,
        description = description,
        isRepeat = isRepeat,
        repeatType = repeatType,
        endDate = endDate.toEpochMilli(),
        notificationEnabled = notificationEnabled,
        notificationTime = notificationTime,
        createdAt = createdAt.toEpochMilli(),
        extendEndDate = extendEndDate,
    )

