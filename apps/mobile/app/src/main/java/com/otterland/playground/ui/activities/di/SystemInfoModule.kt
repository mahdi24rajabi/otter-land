package com.otterland.playground.ui.activities.di

import android.app.Application
import com.otterland.imageloader.systeminfo.DisplaySettingProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SystemInfoModule {

    @Provides
    fun provideSystemInfoRepository(application: Application): DisplaySettingProvider = DisplaySettingProvider(application)
}