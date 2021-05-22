gradlePlugin {
    plugins {
        find { it.name == "com.qux42.gradle.plugins.qux-application" }!!
            .apply {
                id = "com.qux42.gradle.plugins.qux-application"
            }
    }
}


dependencies {
    implementation("gradle.plugin.com.google.cloud.tools:jib-gradle-plugin:${PluginVersions.jibVersion}")
    implementation("com.google.cloud.tools:jib-layer-filter-extension-gradle:${PluginVersions.jibExtensionVersion}")
}