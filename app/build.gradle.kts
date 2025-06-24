plugins {
    alias(libs.plugins.tu.android.application)
    alias(libs.plugins.tu.android.compose)
}

android {
    namespace = "com.jm.thinkup"

    defaultConfig {
        applicationId = "com.jm.thinkup"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)

    implementation(projects.core.designsystem)
    implementation(projects.core.navigation)

    implementation(projects.feature.home)
    implementation(projects.feature.goal)
    implementation(projects.feature.planner)
    implementation(projects.feature.thought)
    implementation(projects.feature.memo)
    implementation(projects.core.util)
}