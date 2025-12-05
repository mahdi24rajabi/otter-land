package com.otterland.imageloader.network.api

import kotlin.properties.ReadOnlyProperty

interface NetworkConnectionProvider<T> : ReadOnlyProperty<Any?, T>