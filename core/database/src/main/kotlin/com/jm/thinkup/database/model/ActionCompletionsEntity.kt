package com.jm.thinkup.database.model

import androidx.room.Entity
import androidx.room.ForeignKey
import com.jm.thinkup.domain.model.ActionCompletion
import com.jm.thinkup.domain.model.ActionId
import kotlinx.datetime.Instant

@Entity(
    tableName = "action_completions_tb",
    primaryKeys = ["actionId", "completionEndDate"],
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
    val completionEndDate: Long,
    val isCompleted: Boolean = false,
    val completedAt: Long? = null
)

fun ActionCompletionsEntity.toDomainModel(): ActionCompletion =
    ActionCompletion(
        actionId = ActionId(actionId),
        completionEndDate = Instant.fromEpochMilliseconds(this@toDomainModel.completionEndDate),
        isCompleted = isCompleted,
        completedAt = completedAt?.let { Instant.fromEpochMilliseconds(it) }
    )

fun ActionCompletion.toEntity(): ActionCompletionsEntity =
    ActionCompletionsEntity(
        actionId = actionId.value,
        completionEndDate = completionEndDate.toEpochMilliseconds(),
        isCompleted = isCompleted,
        completedAt = completedAt?.toEpochMilliseconds()
    )