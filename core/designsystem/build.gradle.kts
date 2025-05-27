import com.jm.thinkup.extension.setNamespace

plugins {
    alias(libs.plugins.tu.android.library)
    alias(libs.plugins.tu.android.compose)
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