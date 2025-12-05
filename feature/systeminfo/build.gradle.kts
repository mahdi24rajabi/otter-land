plugins {
    alias(libs.plugins.android.lib)
    alias(libs.plugins.android.kotlin.dependencies)
    alias(libs.plugins.android.ui.compose)
    alias(libs.plugins.android.ui.libraries)
    alias(libs.plugins.android.dependency.injection)
}

android {
    namespace = "com.otterland.feature.systeminfo"
}

dependencies {
    implementation(project(":libs:foundation:systeminfo"))
    implementation(project(":libs:foundation:design"))
    implementation(project(":libs:foundation:permission"))
}

