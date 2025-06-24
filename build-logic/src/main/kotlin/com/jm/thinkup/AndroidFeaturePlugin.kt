package com.jm.thinkup

import com.android.build.api.dsl.LibraryExtension
import com.jm.thinkup.extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidFeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            println(">>> AndroidFeaturePlugin applying...")
            apply(plugin = "tu.android.library")
            apply(plugin = "tu.android.compose")
            apply(plugin = "org.jetbrains.kotlin.plugin.serialization")

            extensions.configure<LibraryExtension> {
                testOptions.animationsDisabled = true
            }

            dependencies {
                "implementation"(project(":core:ui"))
                "implementation"(project(":core:designsystem"))
                "implementation"(project(":core:model"))
//                "implementation"(project(":core:data"))
                "implementation"(project(":core:domain"))
                "implementation"(project(":core:navigation"))
                "implementation"(project(":core:common"))
                "implementation"(project(":core:util"))

                "implementation"(libs.findLibrary("androidx.hilt.navigation.compose").get())
                "implementation"(libs.findLibrary("androidx.lifecycle.runtime.compose").get())
                "implementation"(libs.findLibrary("androidx.lifecycle.viewModel.compose").get())
                "implementation"(libs.findLibrary("androidx.navigation.compose").get())
                "implementation"(libs.findLibrary("kotlinx.serialization.json").get())
            }
            println(">>> AndroidFeaturePlugin done")
        }
    }
}