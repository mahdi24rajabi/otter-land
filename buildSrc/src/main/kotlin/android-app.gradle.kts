plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.devtools.ksp")
}

private val Project.libs: VersionCatalog
    get() = project.versionCatalogs.find("libs").get()

android {
    compileSdk = 36

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    kotlin {
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
        }
    }

    buildToolsVersion = "35.0.0"


}

dependencies {
    implementation(libs.findLibrary("androidx.appcompat").get())
    implementation(libs.findLibrary("androidx.core.ktx").get())
    implementation(libs.findLibrary("android.google.material").get())
}