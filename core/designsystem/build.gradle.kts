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
}