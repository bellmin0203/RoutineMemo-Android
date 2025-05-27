package com.jm.thinkup

import com.jm.thinkup.extension.configureComposeAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            println(">>> AndroidComposePlugin applying...")
            configureComposeAndroid()
            println(">>> configureComposeAndroid done")
        }
    }
}