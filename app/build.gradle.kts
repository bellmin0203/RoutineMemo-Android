plugins {
    alias(libs.plugins.rm.android.application)
    alias(libs.plugins.rm.android.compose)
}

android {
    namespace = "com.jm.routinememo"

    defaultConfig {
        applicationId = "com.jm.routinememo"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    implementation(projects.core.designsystem)
    implementation(projects.feature.home)

}