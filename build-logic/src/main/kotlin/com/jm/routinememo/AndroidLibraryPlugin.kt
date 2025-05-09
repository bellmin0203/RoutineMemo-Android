package com.jm.routinememo

import com.jm.routinememo.extension.configureCoroutineAndroid
import com.jm.routinememo.extension.configureHiltAndroid
import com.jm.routinememo.extension.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "com.android.library")

            configureKotlinAndroid()
            configureCoroutineAndroid()
            configureHiltAndroid()
        }
    }
}