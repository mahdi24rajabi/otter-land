package com.otterland.imageloader.coil.okhttp.network

import coil3.annotation.ExperimentalCoilApi
import coil3.network.NetworkFetcher
import coil3.network.cachecontrol.CacheControlCacheStrategy
import coil3.network.okhttp.OkHttpNetworkFetcherFactory
import com.otterland.imageloader.coil.network.api.NetworkComponent
import com.otterland.imageloader.network.okhttp.OkHttpClientNetworkConnectionProvider
import kotlin.reflect.KProperty
import kotlin.time.ExperimentalTime

class OkhttpImageLoaderComponent @OptIn(
    ExperimentalCoilApi::class,
    ExperimentalTime::class
) constructor(
    okhttpNetworkProvider: OkHttpClientNetworkConnectionProvider,
    cacheStrategy: CacheControlCacheStrategy = CacheControlCacheStrategy(),
) : NetworkComponent {

    @OptIn(ExperimentalCoilApi::class)
    private val networkFetcherFactory: NetworkFetcher.Factory by lazy {
        OkHttpNetworkFetcherFactory(
            callFactory = { okhttpNetworkProvider.cloneFromBase() },
            cacheStrategy = { cacheStrategy },
        )
    }

    override fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): NetworkFetcher.Factory = networkFetcherFactory
}