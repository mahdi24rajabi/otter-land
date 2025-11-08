plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.kotlin.dependencies)
    alias(libs.plugins.android.ui.compose)
    alias(libs.plugins.android.ui.libraries)
    alias(libs.plugins.android.dependency.injection)
}

android {
    namespace = "com.otterland.playground"

    defaultConfig {
        applicationId = "com.otterland.playground"
        versionCode = 2500000
        versionName = "25.0.000"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
        }

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }

    hilt {
        enableAggregatingTask = true
    }
}

dependencies {
    implementation(project(":libs:foundation:design"))

    implementation(project(":libs:imageloader:api"))
    implementation(project(":libs:imageloader:coil:ui"))
    implementation(project(":libs:imageloader:coil:network:api"))
    implementation(project(":libs:imageloader:coil:network:okhttp"))
    implementation(project(":libs:imageloader:coil:core"))

    implementation(project(":libs:foundation:network:api"))
    implementation(project(":libs:foundation:network:okhttp"))

    implementation(project(":feature:systeminfo"))
    implementation(project(":data:systeminfo"))

    implementation(libs.androidx.spashscreen)
}