import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "rm.android.application"
            implementationClass = "com.jm.routinememo.AndroidApplicationPlugin"
        }

        register("androidHilt") {
            id = libs.plugins.rm.android.hilt.get().pluginId
            implementationClass = "com.jm.routinememo.HiltAndroidPlugin"
        }

        register("androidCompose") {
            id = libs.plugins.rm.android.compose.get().pluginId
            implementationClass = "com.jm.routinememo.AndroidComposePlugin"
        }

        register("androidLibrary") {
            id = "rm.android.library"
            implementationClass = "com.jm.routinememo.AndroidLibraryPlugin"
        }

        register("androidFeature") {
            id = libs.plugins.rm.android.feature.get().pluginId
            implementationClass = "com.jm.routinememo.AndroidFeaturePlugin"
        }

        register("androidRoom") {
            id = libs.plugins.rm.android.room.get().pluginId
            implementationClass = "com.jm.routinememo.AndroidRoomPlugin"
        }
    }
}