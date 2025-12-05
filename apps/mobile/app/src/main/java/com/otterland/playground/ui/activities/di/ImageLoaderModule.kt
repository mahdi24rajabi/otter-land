package com.otterland.playground.ui.activities.di

import android.app.Application
import com.otterland.imageloader.coil.core.CoilNetworkImageLoader
import com.otterland.imageloader.coil.okhttp.network.OkhttpImageLoaderComponent
import com.otterland.imageloader.network.okhttp.OkHttpClientNetworkConnectionProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ImageLoaderModule {

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