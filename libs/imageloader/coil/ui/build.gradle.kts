plugins {
    alias(libs.plugins.android.lib)
    alias(libs.plugins.android.kotlin.dependencies)
    alias(libs.plugins.android.ui.compose)
}

android {
    namespace = "com.otterland.imageloader.coil.ui"
}

dependencies {
    implementation(project(":libs:imageloader:coil:core"))
    implementation(project(":libs:imageloader:api"))

    implementation(platform(libs.imageloader.coil.bom))
    implementation(libs.imageloader.coil.compose)
}