/**
 * Precompiled [android-dependency-injection.gradle.kts][Android_dependency_injection_gradle] script plugin.
 *
 * @see Android_dependency_injection_gradle
 */
class AndroidDependencyInjectionPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Android_dependency_injection_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
