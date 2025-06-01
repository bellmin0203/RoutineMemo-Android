package com.jm.thinkup.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jm.thinkup.domain.model.Goal

@Entity(tableName = "goal_tb")
data class GoalEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val deadlineDate: Long,
    val createdAt: Long = System.currentTimeMillis()
)

fun GoalEntity.toDomainModel(): Goal =
    Goal(
        title = title,
        deadlineDate = deadlineDate,
        createdAt = createdAt
    )