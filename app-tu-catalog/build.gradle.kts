plugins {
    alias(libs.plugins.tu.android.application)
    alias(libs.plugins.tu.android.compose)
}

android {
    namespace = "com.jm.thinkup.tucatalog"

    defaultConfig {
        applicationId = "com.jm.thinkup.tucatalog"
        versionCode = 1
        versionName = "0.0.1" // X.Y.Z; X = Major, Y = minor, Z = Patch level
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(libs.androidx.activity.compose)

    implementation(projects.core.designsystem)
    implementation(projects.core.ui)
}