plugins {
    alias(libs.plugins.android.mackrobenchmark)
}

android {
    namespace = "com.otterland.playground.benchmark"
    targetProjectPath = ":apps:mobile:app"

    buildTypes {
        maybeCreate("release").apply {
            isMinifyEnabled = true
            isDebuggable = false
        }

        create("benchmark") {
            initWith(getByName("release"))
            signingConfig = signingConfigs.getByName("debug")
        }
    }

}

//android {
//    compileSdk {
//        version = release(36)
//    }
//
//    defaultConfig {
//        minSdk = 24
//        targetSdk = 36
//
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//    }
//
//    buildTypes {
//        create("benchmark") {
//            isDebuggable = true
//            signingConfig = getByName("debug").signingConfig
//            matchingFallbacks += listOf("release")
//        }
//    }
//
//    experimentalProperties["android.experimental.self-instrumenting"] = true
//}

