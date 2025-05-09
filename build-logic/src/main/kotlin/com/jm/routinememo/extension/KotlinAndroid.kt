package com.jm.routinememo.extension

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.configureKotlinAndroid() {
    // Plugins
    pluginManager.apply("org.jetbrains.kotlin.android")

    // Android settings
    androidExtension.apply {
        compileSdk = 35

        defaultConfig {
            minSdk = 26
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
        testOptions {
            unitTests {
                isIncludeAndroidResources = true
            }
        }
    }

    configureKotlin()

    val libs = extensions.libs
}

internal fun Project.configureKotlin() {
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
            // Treat all Kotlin warnings as errors (disabled by default)
            // Override by setting warningsAsErrors=true in your ~/.gradle/gradle.properties
            val warningsAsErrors: String? by project
            allWarningsAsErrors.set(warningsAsErrors.toBoolean())
            freeCompilerArgs.set(
                freeCompilerArgs.get() + listOf(
                    "-opt-in=kotlin.RequiresOptIn",
                    /**
                     * data class의 copy() 함수 가시성을 생성자와 일치시키기 위해서 추가
                     *
                     * Remove this args after Phase 3.
                     * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-consistent-copy-visibility/#deprecation-timeline
                     *
                     * Deprecation timeline
                     * Phase 3. (Supposedly Kotlin 2.2 or Kotlin 2.3).
                     * The default changes.
                     * Unless ExposedCopyVisibility is used, the generated 'copy' method has the same visibility as the primary constructor.
                     * The binary signature changes. The error on the declaration is no longer reported.
                     * '-Xconsistent-data-class-copy-visibility' compiler flag and ConsistentCopyVisibility annotation are now unnecessary.
                     */
                    "-Xconsistent-data-class-copy-visibility",
                )
            )
        }
    }
}