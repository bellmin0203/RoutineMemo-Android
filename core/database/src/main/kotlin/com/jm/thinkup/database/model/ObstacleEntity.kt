package com.jm.thinkup.database.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.jm.thinkup.domain.model.GoalId
import com.jm.thinkup.domain.model.Obstacle
import com.jm.thinkup.domain.model.ObstacleId

@Entity(
    tableName = "obstacle_tb",
    foreignKeys = [
        ForeignKey(
            entity = GoalEntity::class,
            parentColumns = ["id"],
            childColumns = ["goalId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ObstacleEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val goalId: Long,
    val description: String
)

fun ObstacleEntity.toDomainModel(): Obstacle =
    Obstacle(
        id = ObstacleId(id),
        goalId = GoalId(goalId),
        description = description
    )

fun Obstacle.toEntity(): ObstacleEntity =
    ObstacleEntity(
        id = id.value,
        goalId = goalId.value,
        description = description
    )