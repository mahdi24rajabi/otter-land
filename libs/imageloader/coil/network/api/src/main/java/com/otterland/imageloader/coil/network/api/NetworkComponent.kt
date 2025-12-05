package com.otterland.imageloader.coil.network.api

import coil3.network.NetworkFetcher
import kotlin.properties.ReadOnlyProperty

interface NetworkComponent : ReadOnlyProperty<Any?, NetworkFetcher.Factory>