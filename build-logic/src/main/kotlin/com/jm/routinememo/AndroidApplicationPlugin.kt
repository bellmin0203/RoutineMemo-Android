package com.jm.routinememo

import com.android.build.api.dsl.ApplicationExtension
import com.jm.routinememo.extension.configureHiltAndroid
import com.jm.routinememo.extension.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            println(">>> AndroidApplicationPlugin applying...")
            apply(plugin = "com.android.application")

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid()
                println(">>> configureKotlinAndroid done")

                configureHiltAndroid()
                println(">>> configureHiltAndroid done")
            }
        }
    }
}