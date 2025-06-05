package com.jm.thinkup.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.jm.thinkup.database.model.ActionCompletionsEntity
import com.jm.thinkup.database.model.ActionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ActionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAction(action: ActionEntity): Long

    @Update
    suspend fun updateAction(action: ActionEntity)

    @Delete
    suspend fun deleteAction(action: ActionEntity)

    @Query("SELECT * FROM action_tb WHERE goalId = :goalId ORDER BY createdAt ASC")
    fun getActionsByGoalId(goalId: Long): Flow<List<ActionEntity>>

    @Query("SELECT * FROM action_tb WHERE obstacleId = :obstacleId ORDER BY createdAt ASC")
    fun getActionsByObstacleId(obstacleId: Long): Flow<List<ActionEntity>>


    //==============================================================================================
    //  ActionCompletion
    //==============================================================================================
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertActionCompletion(actionCompletion: ActionCompletionsEntity)

    @Query("SELECT * FROM action_completions_tb WHERE actionId = :actionId AND completionEndDate = :targetDate")
    suspend fun getActionCompletionByDate(
        actionId: Long,
        targetDate: Long
    ): ActionCompletionsEntity?

    @Query("SELECT * FROM action_completions_tb WHERE actionId = :actionId")
    fun getActionCompletionsByActionId(actionId: Long): Flow<List<ActionCompletionsEntity>>

    @Query("SELECT * FROM action_completions_tb WHERE actionId = :actionId AND completionEndDate <= :targetDate")
    suspend fun getActionCompletionBeforeDate(
        actionId: Long,
        targetDate: Long
    ): List<ActionCompletionsEntity>

    @Query(
        """
        SELECT A.*
        FROM action_tb AS A
        INNER JOIN action_completions_tb AS AC
        ON A.id = AC.actionId
        WHERE A.id = :actionId AND AC.isCompleted = 1
    """
    )
    fun getCompletedActions(actionId: Long): Flow<List<ActionEntity>>

    @Query(
        """
        SELECT A.*
        FROM action_tb AS A
        INNER JOIN action_completions_tb AS AC
        ON A.id = AC.actionId
        WHERE A.id = :actionId AND AC.isCompleted = 1 AND AC.completionEndDate <= :targetDate
    """
    )
    fun getCompletedActionsBeforeDate(actionId: Long, targetDate: Long): Flow<List<ActionEntity>>

    @Query(
        """
        SELECT A.*
        FROM action_tb AS A
        INNER JOIN action_completions_tb AS AC
        ON A.id = AC.actionId
        WHERE A.id = :actionId AND AC.isCompleted = 1 AND AC.completionEndDate = :targetDate
    """
    )
    fun getCompletedActionsByDate(actionId: Long, targetDate: Long): Flow<List<ActionEntity>>

    @Update
    suspend fun updateActionCompletion(actionCompletion: ActionCompletionsEntity)


    // 진행 상황 계산을 위한 쿼리 예시 (복잡해질 수 있으니 Room에서 직접 계산하거나 Repository 레이어에서 처리하는 것이 좋습니다.)
    // SELECT
    //   (SELECT COUNT(*) FROM action_tb WHERE goalId = :goalId AND isRepeat = 0) +
    //   SUM(CASE WHEN A.isRepeat = 1 THEN (SELECT COUNT(DISTINCT C.completionDate) FROM action_completions_tb C WHERE C.actionId = A.id AND C.isCompleted = 1 AND C.completionDate <= :currentDate) ELSE 0 END) AS completedCount,
    //   (SELECT COUNT(*) FROM action_tb WHERE goalId = :goalId AND isRepeat = 0) +
    //   SUM(CASE WHEN A.isRepeat = 1 THEN (SELECT COUNT(DISTINCT DATE(startDate + '+' || (j || ' day'))) FROM actions, (SELECT * FROM R_DAY_NUMBERS WHERE j <= (SELECT JULIANDAY(:currentDate) - JULIANDAY(A.createdAt))) WHERE A.id = actions.id AND (A.recurrenceEndDate IS NULL OR DATE(startDate + '+' || (j || ' day')) <= DATE(A.recurrenceEndDate))) ELSE 0 END) AS totalCount
    // FROM actions A WHERE goalId = :goalId
    // 이 쿼리는 복잡하므로 코드로 구현하는 것이 더 쉬울 수 있습니다.
}