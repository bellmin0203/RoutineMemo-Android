package com.jm.routinememo

import com.jm.routinememo.extension.configureComposeAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureComposeAndroid()
        }
    }
}