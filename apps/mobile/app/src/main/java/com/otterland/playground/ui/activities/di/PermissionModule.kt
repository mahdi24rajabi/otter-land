package com.otterland.playground.ui.activities.di

import android.app.Application
import com.otterland.foundation.permission.SettingPermissionUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PermissionModule {

    @Provides
    fun provideSettingPermissionUtils(application: Application)
        = SettingPermissionUtils(application = application)

}