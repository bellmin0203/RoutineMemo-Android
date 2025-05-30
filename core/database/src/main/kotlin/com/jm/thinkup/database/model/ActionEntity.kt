package com.jm.thinkup.database.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

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
