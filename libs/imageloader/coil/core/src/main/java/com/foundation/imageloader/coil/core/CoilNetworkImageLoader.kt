package com.foundation.imageloader.coil.core

import android.app.Application
import android.content.Context
import android.os.Build.VERSION.SDK_INT
import coil3.ImageLoader
import coil3.SingletonImageLoader
import coil3.annotation.ExperimentalCoilApi
import coil3.disk.DiskCache
import coil3.disk.directory
import coil3.gif.AnimatedImageDecoder
import coil3.gif.GifDecoder
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.svg.SvgDecoder
import com.foundation.imageloader.coil.core.mapper.RemoteImageMapper
import com.foundation.imageloader.coil.core.mapper.ResourceImageMapper
import com.otterland.imageloader.network.api.NetworkComponent
import kotlinx.coroutines.Dispatchers

private const val CACHE_DIR = "image_cache"

class CoilNetworkImageLoader(
    application: Application,
    networkComponent: NetworkComponent
) {

    private val network by networkComponent

    init {
        SingletonImageLoader.setSafe {
            ImageLoader.Builder(application)
                .setComponents()
                .diskCachePolicy(CachePolicy.ENABLED)
                .setCoroutineContext()
                .setMemoryCache(application)
                .setDiskCache(application)
                .build()
        }
    }

    private fun ImageLoader.Builder.setComponents() = this.apply {
        components {
            add(ResourceImageMapper())
            add(RemoteImageMapper())
            add(network)
            add(
                when {
                    SDK_INT >= 28 -> AnimatedImageDecoder.Factory()
                    else -> GifDecoder.Factory()
                }
            )
            add(SvgDecoder.Factory())
        }
    }

    @OptIn(ExperimentalCoilApi::class)
    private fun ImageLoader.Builder.setCoroutineContext() = this.apply {
        mainCoroutineContext(Dispatchers.Main)
        fetcherCoroutineContext(Dispatchers.IO)
        decoderCoroutineContext(Dispatchers.Default)
        interceptorCoroutineContext(Dispatchers.Default)
    }

    private fun ImageLoader.Builder.setMemoryCache(contextual: Context) = this.apply {
        memoryCache {
            MemoryCache.Builder()
                .maxSizePercent(contextual, 0.25)
                .build()
        }
    }

    private fun ImageLoader.Builder.setDiskCache(context: Context) = this.apply {
        diskCache {
            DiskCache.Builder()
                .directory(context.cacheDir.resolve(CACHE_DIR))
                .cleanupCoroutineContext(Dispatchers.IO)
                .maxSizePercent(0.02)
                .build()
        }
    }
}