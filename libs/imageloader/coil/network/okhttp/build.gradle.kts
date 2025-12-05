plugins {
    alias(libs.plugins.android.lib)
    alias(libs.plugins.android.kotlin.dependencies)
}

android {
    namespace = "com.otterland.imageloader.coil.network.okhttp"
}

dependencies {
    implementation(project(":libs:imageloader:coil:network:api"))
    implementation(project(":libs:foundation:network:api"))
    implementation(project(":libs:foundation:network:okhttp"))

    implementation(platform(libs.imageloader.coil.bom))
    implementation(libs.imageloader.coil.cache.strategy)
    implementation(libs.imageloader.coil.okhttp)
}