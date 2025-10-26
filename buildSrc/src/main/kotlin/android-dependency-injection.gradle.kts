plugins {
    id("com.google.dagger.hilt.android")
}

private val Project.libs: VersionCatalog
    get () = project.versionCatalogs.find("libs").get()

dependencies {
    add( "implementation", libs.findLibrary("dependency-injection-dagger-hilt").get())
    add("ksp", libs.findLibrary("dependency-injection-dagger-hilt-compiler").get())
}