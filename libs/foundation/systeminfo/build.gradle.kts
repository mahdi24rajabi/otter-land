plugins {
    alias(libs.plugins.android.lib)
    alias(libs.plugins.android.ui.compose)
}

android {
    namespace = "com.otterland.imageloader.systeminfo"
}

dependencies {
    implementation(libs.androidx.appcompat)
}
