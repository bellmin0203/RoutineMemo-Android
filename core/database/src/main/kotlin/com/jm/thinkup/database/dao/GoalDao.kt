package com.jm.thinkup.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.jm.thinkup.database.model.GoalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GoalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGoal(goal: GoalEntity): Long

    @Update
    suspend fun updateGoal(goal: GoalEntity)

    @Delete
    suspend fun deleteGoal(goal: GoalEntity)

    @Query("SELECT * FROM goal_tb WHERE id = :id")
    fun getGoalById(id: Long): Flow<GoalEntity?>

    @Query("SELECT * FROM goal_tb ORDER BY deadlineDate ASC")
    fun getAllGoals(): Flow<List<GoalEntity>>

    // 목표와 관련된 문제점, 실천 항목을 함께 가져오는 쿼리는 Relation을 사용합니다.
    // GoalWithProblemsAndActions 같은 데이터 클래스를 정의하여 사용
    // @Transaction
    // @Query("SELECT * FROM goals WHERE id = :goalId")
    // fun getGoalWithDetails(goalId: Long): Flow<GoalWithProblemsAndActions>

}