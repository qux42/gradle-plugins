plugins {
    `kotlin-dsl` apply false
    id("de.seewes.git.version") version PluginVersions.seewesGitVersion apply false
}

subprojects {
    apply(plugin = "maven-publish")
    apply(plugin = "org.gradle.kotlin.kotlin-dsl")
    apply(plugin = "de.seewes.git.version")

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    //adding 9999- in front of all Snapshots to fix dependency-resolution
    val patchedVersion = if ("$version".endsWith("SNAPSHOT")) "9999-${version}" else version
    version = patchedVersion

    group = "com.qux42.gradle.plugins"
}

tasks.wrapper {
    gradleVersion = PluginVersions.gradleVersion
}
