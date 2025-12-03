plugins {
    id("com.android.test")
}

private val Project.libs: VersionCatalog
    get() = project.versionCatalogs.find("libs").get()

//dependencies {
//    add("implementation", libs.findLibrary("test-junit").get())
//    add("implementation", libs.findLibrary("test-kotlin-coroutines").get())
//    add("implementation", libs.findLibrary("test-mokk").get())
//    add("implementation", libs.findLibrary("test-uiautomator"))
//    add("implementation", libs.findLibrary("test-benchmark.macro.junit4"))
//}

//androidComponents {
//    beforeVariants(selector().all()) {
//        it.enable = it.buildType == "benchmark"
//    }
//}