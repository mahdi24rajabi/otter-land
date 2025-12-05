package com.otterland.imageloader.coil.core.mapper

import coil3.map.Mapper
import coil3.request.Options
import com.otterland.imageloader.api.ResourceImage

class ResourceImageMapper : Mapper<ResourceImage, Int> {
    override fun map(
        data: ResourceImage,
        options: Options
    ): Int = data.id
}