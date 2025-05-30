package com.jm.thinkup.database.di

import android.content.Context
import androidx.room.Room
import com.jm.thinkup.database.ThinkUpDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun providesThinkUpDatabase(
        @ApplicationContext context: Context,
    ): ThinkUpDatabase = Room.databaseBuilder(
        context = context,
        klass = ThinkUpDatabase::class.java,
        name = "thinkup-database"
    ).build()
}