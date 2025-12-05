plugins {
    id("com.android.library")
    kotlin("android")
    id("com.google.devtools.ksp")
}

private val Project.libs: VersionCatalog
    get() = project.versionCatalogs.find("libs").get()

android {
    compileSdk = 36

    defaultConfig {
        minSdk = 24
        consumerProguardFiles("consumer-rules.pro")
    }

    kotlin {
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
        }
    }

    buildTypes {
        getByName("debug") {
        }

        getByName("release") {
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true //Roboelectrics
        }
    }

    buildToolsVersion = "35.0.0"
}

dependencies {
    androidTestImplementation("com.google.errorprone:error_prone_annotations:2.45.0")
}