private val Project.libs: VersionCatalog
    get() = project.versionCatalogs.find("libs").get()

dependencies {
    add("testImplementation", libs.findLibrary("test-junit").get())
    add("testImplementation", libs.findLibrary("test-kotlin-coroutines").get())
    add("testImplementation", libs.findLibrary("test-mokk").get())
    add("testImplementation", libs.findLibrary("test-roboelectric").get())
}