package com.otterland.imageloader.network.api

import coil3.network.NetworkFetcher
import kotlin.properties.ReadOnlyProperty

interface NetworkComponent : ReadOnlyProperty<Any?, NetworkFetcher.Factory>