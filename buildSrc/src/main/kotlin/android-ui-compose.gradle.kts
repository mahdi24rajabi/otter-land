plugins {
    id("org.jetbrains.kotlin.plugin.compose")
}


private val Project.libs: VersionCatalog
    get () = project.versionCatalogs.find("libs").get()

dependencies {
    add("implementation", platform(libs.findLibrary("ui.compose.bom").get()))
    add("implementation", libs.findLibrary("ui.compose.material3").get())
    add("implementation", libs.findLibrary("ui.compose.preview").get())
    add("implementation", libs.findLibrary("ui.compose.adaptive").get())
    add("implementation", libs.findLibrary("ui.compose.activity").get())
    add("implementation", libs.findLibrary("ui.compose.viewmodel").get())
    add("implementation", libs.findLibrary("ui.compose.google.fonts").get())
    add("implementation", libs.findLibrary("ui.navigation.compose").get())

    add("debugImplementation", libs.findLibrary("ui.compose.tools").get())
}