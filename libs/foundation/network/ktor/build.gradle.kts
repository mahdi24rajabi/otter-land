plugins {
    alias(libs.plugins.android.lib)
    alias(libs.plugins.android.kotlin.dependencies)
}

android {
    namespace = "com.otterland.foundation.network.ktor"
}

dependencies {
    implementation(project(":libs:foundation:network:api"))
}

