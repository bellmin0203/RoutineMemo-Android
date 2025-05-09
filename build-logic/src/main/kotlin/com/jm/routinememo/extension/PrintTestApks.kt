package com.jm.routinememo.extension

import com.android.build.api.artifact.SingleArtifact
import com.android.build.api.variant.AndroidComponentsExtension
import com.android.build.api.variant.HasAndroidTest
import org.gradle.api.Project

internal fun Project.configurePrintApksTask(extension: AndroidComponentsExtension<*, *, *>) {
    extension.onVariants { variant ->
        if (variant is HasAndroidTest) {
            val loader = variant.artifacts.getBuiltArtifactsLoader()
            val artifact = variant.androidTest?.artifacts?.get(SingleArtifact.APK)
            val javaSources = variant.androidTest?.sources?.java?.all
            val kotlinSources = variant.androidTest?.sources?.kotlin?.all


        }
    }
}