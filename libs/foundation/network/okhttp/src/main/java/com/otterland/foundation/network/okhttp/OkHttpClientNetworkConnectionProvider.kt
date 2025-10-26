package com.otterland.foundation.network.okhttp

import com.otterland.foundation.network.api.NetworkConnectionProvider
import okhttp3.OkHttpClient
import kotlin.reflect.KProperty

class OkHttpClientNetworkConnectionProvider() : NetworkConnectionProvider<OkHttpClient> {

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }

    fun cloneFromBase(): OkHttpClient {
        val baseClient by this
        return baseClient.newBuilder().build()
    }

    override fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): OkHttpClient = okHttpClient

}