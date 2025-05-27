package com.jm.thinkup.extension

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.ExtensionContainer
import org.gradle.kotlin.dsl.getByType

/**************************************************************************************************
 * title : Extension.kt
 *
 * description : Gradle Kotlin DSL을 사용할 때, Android 프로젝트에서 공통 설정을 쉽게 구성하기 위한
 * 확장 프로퍼티들
 *
 *
 * @author    jongmin han
 **************************************************************************************************/

/**
 * @return com.android.application 플러그인 적용된 프로젝트에서 제공
 *
 * 공통적인 DSL(compileSdk, defaultConfig 등)
 */
internal val Project.applicationExtension: CommonExtension<*, *, *, *, *, *>
    get() = extensions.getByType<ApplicationExtension>()

/**
 * @return com.android.library 플러그인 적용된 프로젝트에서 제공
 */
internal val Project.libraryExtension: CommonExtension<*, *, *, *, *, *>
    get() = extensions.getByType<LibraryExtension>()

/**
 * @return 라이브러리 모듈이면 libraryExtension
 *
 * 앱 모듈이면 applicationExtension
 *
 * 둘 다 없으면 에러 발생
 */
internal val Project.androidExtension: CommonExtension<*, *, *, *, *, *>
    get() = kotlin.runCatching { libraryExtension }
        .recoverCatching { applicationExtension }
        .onFailure { println("Could not find Library or Application extension from this project") }
        .getOrThrow()

/**
 * @return libs.versions.toml에 정의된 libs 카탈로그
 */
val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun Project.setNamespace(name: String) {
    androidExtension.apply {
        namespace = "com.jm.thinkup.$name"
    }
}