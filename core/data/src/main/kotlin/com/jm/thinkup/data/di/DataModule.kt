package com.jm.thinkup.data.di

import com.jm.thinkup.data.repository.ActionsRepositoryImpl
import com.jm.thinkup.data.repository.GoalsRepositoryImpl
import com.jm.thinkup.data.repository.ObstaclesRepositoryImpl
import com.jm.thinkup.data.repository.ProgressRepositoryImpl
import com.jm.thinkup.domain.repository.ActionsRepository
import com.jm.thinkup.domain.repository.GoalsRepository
import com.jm.thinkup.domain.repository.ObstaclesRepository
import com.jm.thinkup.domain.repository.ProgressRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsGoalRepository(
        goalsRepositoryImpl: GoalsRepositoryImpl
    ): GoalsRepository

    @Binds
    abstract fun bindsObstacleRepository(
        obstaclesRepositoryImpl: ObstaclesRepositoryImpl
    ): ObstaclesRepository

    @Binds
    abstract fun bindsActionRepository(
        actionsRepositoryImpl: ActionsRepositoryImpl
    ): ActionsRepository

    @Binds
    abstract fun bindsProgressRepository(
        progressRepositoryImpl: ProgressRepositoryImpl
    ): ProgressRepository
}