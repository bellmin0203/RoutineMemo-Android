package com.jm.thinkup.database.model

import androidx.room.Entity
import androidx.room.ForeignKey
import com.jm.thinkup.domain.model.ActionCompletion

@Entity(
    tableName = "action_completions_tb",
    primaryKeys = ["actionId", "completionDate"],
    foreignKeys = [
        ForeignKey(
            entity = ActionEntity::class,
            parentColumns = ["id"],
            childColumns = ["actionId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ActionCompletionsEntity(
    val actionId: Long,
    val completionDate: Long,
    val isCompleted: Int = 0,
    val completedAt: Long
)

fun ActionCompletionsEntity.toDomainModel(): ActionCompletion =
    ActionCompletion(
        actionId = actionId,
        completionDate = completionDate,
        isCompleted = isCompleted,
        completedAt = completedAt
    )