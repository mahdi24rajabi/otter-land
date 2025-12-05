plugins {
    id("com.android.test")
}

android {
    compileSdk = 36

    defaultConfig {
        minSdk = 24
    }
}

dependencies {
    implementation("com.google.errorprone:error_prone_annotations:2.28.0")
}