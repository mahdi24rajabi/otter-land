plugins {
    alias(libs.plugins.android.lib)
    alias(libs.plugins.android.ui.compose)
}

android {
    namespace = "com.otterland.imageloader.design"
}
dependencies {
    implementation(libs.androidx.runtime)
    implementation(libs.androidx.appcompat)
}
