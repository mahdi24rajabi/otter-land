/**
 * Precompiled [kotlin-dependencies.gradle.kts][Kotlin_dependencies_gradle] script plugin.
 *
 * @see Kotlin_dependencies_gradle
 */
public
class KotlinDependenciesPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Kotlin_dependencies_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
