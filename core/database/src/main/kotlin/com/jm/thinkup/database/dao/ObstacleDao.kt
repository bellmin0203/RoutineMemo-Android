package com.jm.thinkup.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.jm.thinkup.database.model.ObstacleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ObstacleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertObstacle(obstacle: ObstacleEntity): Long

    @Query("SELECT * FROM obstacle_tb WHERE goalId = :goalId ORDER BY id ASC")
    fun getObstaclesByGoalId(goalId: Long): Flow<List<ObstacleEntity>>

    @Update
    suspend fun updateObstacle(obstacle: ObstacleEntity)

    @Delete
    suspend fun deleteObstacle(obstacle: ObstacleEntity)
}