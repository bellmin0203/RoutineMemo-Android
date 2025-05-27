package com.jm.thinkup

import com.jm.thinkup.extension.configureHiltAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

class HiltAndroidPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            println(">>> HiltAndroidPlugin applying...")
            configureHiltAndroid()
            println(">>> configureHiltAndroid done")
        }
    }
}