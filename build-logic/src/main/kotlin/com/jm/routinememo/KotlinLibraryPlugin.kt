package com.jm.routinememo

import com.jm.routinememo.extension.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class KotlinLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "org.jetbrains.kotlin.jvm")
            configureKotlin()
        }
    }
}