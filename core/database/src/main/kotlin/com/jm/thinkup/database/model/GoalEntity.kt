package com.jm.thinkup.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "goal_tb")
data class GoalEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val deadlineDate: Long,
    val createdAt: Long = System.currentTimeMillis()
)