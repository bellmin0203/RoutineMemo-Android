package com.jm.routinememo

import com.jm.routinememo.extension.configureHiltAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

class HiltAndroidPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureHiltAndroid()
        }
    }
}