plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.gradle.android)
    implementation(libs.gradle.kotlin)
    implementation(libs.gradle.kotlin.serialization)
    implementation(libs.gradle.android.compose.compiler)
    implementation(libs.gradle.dependency.injection.hitl)
    implementation(libs.gradle.kotlin.ksp)
    implementation(libs.gradle.baseprofile)
}