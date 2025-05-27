import com.jm.routinememo.extension.setNamespace

plugins {
    alias(libs.plugins.rm.android.library)
    alias(libs.plugins.rm.android.compose)
}

android {
    setNamespace("core.designsystem")
}

dependencies {
    implementation(libs.androidx.appcompat)
    api(libs.androidx.compose.material3.windowSizeClass)
    api(libs.androidx.compose.material3.navigationSuite)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.runtime)
}