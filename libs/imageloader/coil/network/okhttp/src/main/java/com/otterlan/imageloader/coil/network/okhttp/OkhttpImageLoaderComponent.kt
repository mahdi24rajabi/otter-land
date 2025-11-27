package com.otterlan.imageloader.coil.network.okhttp

import coil3.annotation.ExperimentalCoilApi
import coil3.network.NetworkFetcher
import coil3.network.cachecontrol.CacheControlCacheStrategy
import coil3.network.okhttp.OkHttpNetworkFetcherFactory
import com.otterland.foundation.network.okhttp.OkHttpClientNetworkConnectionProvider
import com.otterland.imageloader.network.api.NetworkComponent
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