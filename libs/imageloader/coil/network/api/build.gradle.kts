plugins {
    alias(libs.plugins.android.lib)
    alias(libs.plugins.android.kotlin.dependencies)
}

android {
    namespace = "com.otterland.imageloader.network.api"
}

dependencies {
    implementation(platform(libs.imageloader.coil.bom))
    implementation(libs.imageloader.coil.cache.strategy)
}