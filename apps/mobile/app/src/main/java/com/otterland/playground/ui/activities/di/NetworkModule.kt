package com.otterland.playground.ui.activities.di

import com.otterland.foundation.network.okhttp.OkHttpClientNetworkConnectionProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideNetworkConnectionProvider() = OkHttpClientNetworkConnectionProvider()
}