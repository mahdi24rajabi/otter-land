plugins {
    id("com.android.library")
    kotlin("android")
    id("com.google.devtools.ksp")
}

private val Project.libs: VersionCatalog
    get () = project.versionCatalogs.find("libs").get()

android {
    compileSdk = 36

    defaultConfig {
        minSdk = 24
    }

    kotlin {
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
        }
    }

    buildToolsVersion = "35.0.0"
}