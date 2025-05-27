package com.jm.thinkup

import com.jm.thinkup.extension.configureCoroutineAndroid
import com.jm.thinkup.extension.configureHiltAndroid
import com.jm.thinkup.extension.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            println(">>> AndroidLibraryPlugin applying...")
            apply(plugin = "com.android.library")

            configureKotlinAndroid()
            println(">>> configureKotlinAndroid done")
            configureCoroutineAndroid()
            println(">>> configureCoroutineAndroid done")
            configureHiltAndroid()
            println(">>> configureHiltAndroid done")
        }
    }
}