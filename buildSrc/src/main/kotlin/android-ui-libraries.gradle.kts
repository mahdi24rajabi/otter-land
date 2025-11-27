private val Project.libs: VersionCatalog
    get() = project.versionCatalogs.find("libs").get()

dependencies {
    add("implementation", libs.findLibrary("ui-navigation-view").get())
    add("implementation", libs.findLibrary("ui-navigation-fragment").get())
    add("implementation", libs.findLibrary("ui-navigation-view-ktx").get())
    add("implementation", libs.findLibrary("ui-navigation-feature").get())

    add("androidTestImplementation", libs.findLibrary("test-ui-navigation").get())
}