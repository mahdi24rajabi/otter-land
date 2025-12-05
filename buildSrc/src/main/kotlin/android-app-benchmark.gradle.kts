plugins {
    id("com.android.test")
    id("androidx.baselineprofile")
}

android {
    compileSdk = 36

    defaultConfig {
        minSdk = 24
        targetSdk = 36
    }
}

dependencies {
    implementation("com.google.errorprone:error_prone_annotations:2.45.0")
}