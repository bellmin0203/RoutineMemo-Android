package com.jm.routinememo.extension

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureCoroutineAndroid() {
    val libs = extensions.libs
    configureCoroutineKotlin()
    dependencies {
        "implementation"(libs.findLibrary("kotlinx.coroutine.android").get())
    }
}

internal fun Project.configureCoroutineKotlin() {
    val libs = extensions.libs
    dependencies {
        "implementation"(libs.findLibrary("kotlinx.coroutine.core").get())
        "testImplementation"(libs.findLibrary("kotlinx.coroutine.test").get())
    }
}