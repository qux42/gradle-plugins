package com.qux42.gradle.plugins

import org.gradle.api.provider.Property

interface ApplicationExtension {
    val mainClassName: Property<String>
    val imageName: Property<String>
    val imageRegistry: Property<String>
    val baseImage: Property<String>
}
