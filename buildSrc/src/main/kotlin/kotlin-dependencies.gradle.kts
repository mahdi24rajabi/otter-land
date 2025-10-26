plugins {
    kotlin("plugin.serialization")
}

private val Project.libs: VersionCatalog
    get () = project.versionCatalogs.find("libs").get()

dependencies {
    add("implementation", libs.findLibrary("kotlinx.coroutines.core").get())
    add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
    add("implementation", libs.findLibrary("kotlin.serialization").get())
}