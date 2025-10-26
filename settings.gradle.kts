settings.rootProject.name = "My test playground"

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Otter Land"

include(":apps:mobile:app")
include(":libs:foundation:network:api")
include(":libs:foundation:network:ktor")
include(":libs:foundation:network:okhttp")
include(":libs:imageloader:api")
include(":libs:imageloader:coil:core")
include(":libs:imageloader:coil:network:okhttp")
include(":libs:imageloader:coil:ui")
include(":libs:imageloader:coil:network:api")
include(":libs:foundation:design")
