package com.otterland.imageloader.coil.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil3.SingletonImageLoader
import coil3.compose.AsyncImage
import com.otterland.imageloader.api.RemoteImage
import com.otterland.imageloader.api.ResourceImage

@Composable
fun CoilImageLoader(
    image: RemoteImage,
    contentScale: ContentScale,
    modifier: Modifier,
) {
    val imageLoader = SingletonImageLoader.get(LocalContext.current.applicationContext)
    AsyncImage(
        model = image,
        contentScale = contentScale,
        modifier = modifier,
        contentDescription = "",
        imageLoader = imageLoader
    )
}

@Composable
fun CoilImageLoader(
    image: ResourceImage,
    contentScale: ContentScale,
    modifier: Modifier,
) {
    val imageLoader = SingletonImageLoader.get(LocalContext.current.applicationContext)

    AsyncImage(
        model = image,
        contentScale = contentScale,
        modifier = modifier,
        contentDescription = "",
        imageLoader = imageLoader
    )
}