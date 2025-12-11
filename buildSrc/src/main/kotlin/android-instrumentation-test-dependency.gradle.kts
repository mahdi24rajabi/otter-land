private val Project.libs: VersionCatalog
    get() = project.versionCatalogs.find("libs").get()

dependencies {
    add("androidTestImplementation", libs.findLibrary("test-androidx-runner").get())
    add("androidTestImplementation", libs.findLibrary("test-androidx-rules").get())
    add("androidTestImplementation", libs.findLibrary("test-androidx-espresso-core").get())
    add("androidTestImplementation", libs.findLibrary("test-compose").get())
}