package com.otterland.playground.ui.activities.di

import android.app.Application
import com.foundation.imageloader.coil.core.CoilNetworkImageLoader
import com.otterlan.imageloader.coil.network.okhttp.OkhttpImageLoaderComponent
import com.otterland.foundation.network.okhttp.OkHttpClientNetworkConnectionProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ImageLoaderModule {

    @Provides
    fun provideImageLoader(
        application: Application,
        networkConnectionProvider: OkHttpClientNetworkConnectionProvider,
    ): CoilNetworkImageLoader =
        CoilNetworkImageLoader(
            application = application,
            networkComponent = OkhttpImageLoaderComponent(okhttpNetworkProvider = networkConnectionProvider)
        )
}