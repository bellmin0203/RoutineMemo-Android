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
            id = libs.plugins.tu.android.application.get().pluginId
            implementationClass = "com.jm.thinkup.AndroidApplicationPlugin"
        }

        register("androidHilt") {
            id = libs.plugins.tu.android.hilt.get().pluginId
            implementationClass = "com.jm.thinkup.HiltAndroidPlugin"
        }

        register("androidCompose") {
            id = libs.plugins.tu.android.compose.get().pluginId
            implementationClass = "com.jm.thinkup.AndroidComposePlugin"
        }

        register("androidLibrary") {
            id = libs.plugins.tu.android.library.get().pluginId
            implementationClass = "com.jm.thinkup.AndroidLibraryPlugin"
        }

        register("androidFeature") {
            id = libs.plugins.tu.android.feature.get().pluginId
            implementationClass = "com.jm.thinkup.AndroidFeaturePlugin"
        }

        register("androidRoom") {
            id = libs.plugins.tu.android.room.get().pluginId
            implementationClass = "com.jm.thinkup.AndroidRoomPlugin"
        }

        register("kotlinLibrary") {
            id = libs.plugins.tu.kotlin.library.get().pluginId
            implementationClass = "com.jm.thinkup.KotlinLibraryPlugin"
        }
    }
}