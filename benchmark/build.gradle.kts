plugins {
    alias(libs.plugins.android.mackrobenchmark)
}

android {
    namespace = "com.otterland.playground.benchmark"
    targetProjectPath = ":apps:mobile:app"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        testInstrumentationRunnerArguments["androidx.benchmark.dryRunMode.enable"] = "true"
        testInstrumentationRunnerArguments["androidx.benchmark.compilation.enabled"] = "false"
        testInstrumentationRunnerArguments["androidx.benchmark.fullTracing.enable"] = "true"
        testInstrumentationRunnerArguments["androidx.benchmark.profiling.mode"] = "StackSampling"
        testInstrumentationRunnerArguments["androidx.benchmark.startupProfiles.enable"] = "true"
        testInstrumentationRunnerArguments["additionalTestOutputDir"] = project.rootDir.path
    }

    buildTypes {
        create("benchmark") {
            isDebuggable = true
            signingConfig = getByName("debug").signingConfig
            matchingFallbacks += listOf("release")
        }
    }

    experimentalProperties["android.experimental.self-instrumenting"] = true
}

dependencies {
    implementation(libs.androidx.junit)
    implementation(libs.androidx.espresso.core)
    implementation(libs.test.uiautomator)
    implementation(libs.test.benchmark.macro.junit4)
}
