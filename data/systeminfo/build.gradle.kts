plugins {
    alias(libs.plugins.android.lib)
    alias(libs.plugins.android.ui.compose)
}

android {
    namespace = "com.otterland.data.system"

    ndkVersion = "29.0.14206865"

    externalNativeBuild {

        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
    defaultConfig {
        externalNativeBuild {
            cmake {
                cppFlags += ""
            }
        }
    }
}