package com.jm.thinkup.database.di

import com.jm.thinkup.database.ThinkUpDatabase
import com.jm.thinkup.database.dao.ActionDao
import com.jm.thinkup.database.dao.GoalDao
import com.jm.thinkup.database.dao.ObstacleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaosModule {
    @Provides
    fun providesGoalDao(
        database: ThinkUpDatabase,
    ): GoalDao = database.goalDao()

    @Provides
    fun providesObstacleDao(
        database: ThinkUpDatabase,
    ): ObstacleDao = database.obstacleDao()

    @Provides
    fun providesActionDao(
        database: ThinkUpDatabase,
    ): ActionDao = database.actionDao()
}