plugins {
    alias(libs.plugins.android.lib)
    alias(libs.plugins.android.kotlin.dependencies)
}

android {
    namespace = "com.otterland.foundation.network.okhttp"
}

dependencies {
    implementation(project(":libs:foundation:network:api"))

    implementation(platform(libs.network.okhttp.bom))
    implementation(libs.network.okhttp)
}