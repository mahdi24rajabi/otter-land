package com.otterland.playground.ui.activities.di

import android.app.Application
import com.otterland.data.system.SystemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SystemInfoModule {

    @Provides
    fun provideSystemInfoRepository(application: Application) = SystemRepository(application)
}