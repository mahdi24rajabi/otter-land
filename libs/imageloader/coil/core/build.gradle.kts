plugins {
    alias(libs.plugins.android.lib)
    alias(libs.plugins.android.kotlin.dependencies)
}

android {
    namespace = "com.otterland.imageloader.coil.core"
}

dependencies {
    implementation(project(":libs:imageloader:api"))
    implementation(project(":libs:imageloader:coil:network:api"))

    implementation(platform(libs.imageloader.coil.bom))
    implementation(libs.imageloader.coil)
    implementation(libs.imageloader.coil.network.core)
    implementation(libs.imageloader.coil.core)
    implementation(libs.imageloader.coil.gif)
    implementation(libs.imageloader.coil.svg)
    implementation(libs.imageloader.coil.video)
}