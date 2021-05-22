package com.qux42.gradle.plugins

plugins {
    id("com.google.cloud.tools.jib")
    application
}

val quxAppExtension = project.extensions.create<ApplicationExtension>("quxApplication")


tasks.distZip {
    enabled = false
}
tasks.distTar {
    enabled = false
}

afterEvaluate {
    application {
        mainClass.set(quxAppExtension.mainClassName.get())
    }
    jib {
        from {
            image = quxAppExtension.baseImage.get()
        }
        to {
            image = quxAppExtension.imageRegistry.get() + quxAppExtension.imageName.get()
        }
        container {
            mainClass = quxAppExtension.mainClassName.get()
            creationTime = "USE_CURRENT_TIMESTAMP"
        }
        pluginExtensions {
            pluginExtension {
                implementation = "com.google.cloud.tools.jib.gradle.extension.layerfilter.JibLayerFilterExtension"
                configuration(Action<com.google.cloud.tools.jib.gradle.extension.layerfilter.Configuration> {
                    filters {
                    }
                })
            }
        }
    }
}