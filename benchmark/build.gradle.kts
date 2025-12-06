plugins {
    alias(libs.plugins.android.mackrobenchmark)
}

android {
    namespace = "com.otterland.playground.macrobenchmark"
    targetProjectPath = ":apps:mobile:app"

    signingConfigs {
        maybeCreate("debug").apply {
            storeFile = file( "../key_stores/debug_key.jks")
            keyAlias = "otterland_debug"
            keyPassword = "Test2025"
            storePassword = "Test2025"
        }
        maybeCreate("release").apply {
            storeFile = file("../key_stores/debug_key.jks")
            keyAlias = "otterland_debug"
            keyPassword = "Test2025"
            storePassword = "Test2025"
        }
    }

    buildTypes {
        create("benchmark") {
            isDebuggable = true
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    experimentalProperties["android.experimental.self-instrumenting"] = true
}

dependencies {
    implementation(libs.androidx.junit)
    implementation(libs.androidx.espresso.core)
    implementation(libs.test.uiautomator)
    implementation(libs.test.benchmark.macro.junit4)
    implementation("androidx.tracing:tracing-perfetto:1.0.0")
    implementation("androidx.tracing:tracing-perfetto-binary:1.0.0")
}
