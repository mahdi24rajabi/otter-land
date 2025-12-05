plugins {
    alias(libs.plugins.android.mackrobenchmark)
    alias(libs.plugins.baselineprofile)
}

android {
    namespace = "com.otterland.playground.benchmark"
    targetProjectPath = ":apps:mobile:app"

    buildTypes {
        maybeCreate("debug").apply {
            isMinifyEnabled = false
            isDebuggable = true
        }

        maybeCreate("release").apply {
            isMinifyEnabled = true
            isDebuggable = false
        }

        create("benchmark") {
            initWith(getByName("release"))
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks += listOf("release")
        }
    }

}

dependencies {
//    implementation(libs.test.kotlin.coroutines)
//    implementation(libs.test.mokk)
    implementation(libs.test.uiautomator)
    implementation(libs.test.benchmark.macro.junit4)
//    implementation(libs.test.benchmark.junit)
}
