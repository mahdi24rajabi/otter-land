package com.otterland.foundation.network.api

import kotlin.properties.ReadOnlyProperty

interface NetworkConnectionProvider<T> : ReadOnlyProperty<Any?, T>