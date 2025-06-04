package com.jm.thinkup.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jm.thinkup.database.dao.ActionDao
import com.jm.thinkup.database.dao.GoalDao
import com.jm.thinkup.database.dao.ObstacleDao
import com.jm.thinkup.database.model.ActionCompletionsEntity
import com.jm.thinkup.database.model.ActionEntity
import com.jm.thinkup.database.model.GoalEntity
import com.jm.thinkup.database.model.ObstacleEntity
import com.jm.thinkup.database.util.RepeatTypeConverter

@Database(
    entities = [
        GoalEntity::class,
        ObstacleEntity::class,
        ActionEntity::class,
        ActionCompletionsEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(RepeatTypeConverter::class)
internal abstract class ThinkUpDatabase : RoomDatabase() {
    abstract fun goalDao(): GoalDao
    abstract fun obstacleDao(): ObstacleDao
    abstract fun actionDao(): ActionDao
}