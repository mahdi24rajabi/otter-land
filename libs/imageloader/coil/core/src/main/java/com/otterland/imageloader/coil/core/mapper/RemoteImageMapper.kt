package com.otterland.imageloader.coil.core.mapper

import coil3.Uri
import coil3.map.Mapper
import coil3.request.Options
import coil3.toCoilUri
import com.otterland.imageloader.api.RemoteImage

class RemoteImageMapper : Mapper<RemoteImage, Uri> {
    override fun map(data: RemoteImage, options: Options): Uri = data.uri.toCoilUri()
}