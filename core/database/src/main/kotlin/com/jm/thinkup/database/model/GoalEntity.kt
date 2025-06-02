package com.jm.thinkup.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jm.thinkup.domain.model.Goal
import com.jm.thinkup.domain.model.GoalId
import java.time.Instant

@Entity(tableName = "goal_tb")
data class GoalEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val deadlineDate: Long,
    val createdAt: Long = System.currentTimeMillis()
)

fun GoalEntity.toDomainModel(): Goal =
    Goal(
        id = GoalId(id),
        title = title,
        deadlineDate = Instant.ofEpochMilli(deadlineDate),
        createdAt = Instant.ofEpochMilli(createdAt)
    )

fun Goal.toEntity(): GoalEntity =
    GoalEntity(
        id = id.value,
        title = title,
        deadlineDate = deadlineDate.toEpochMilli(),
        createdAt = createdAt.toEpochMilli()
    )