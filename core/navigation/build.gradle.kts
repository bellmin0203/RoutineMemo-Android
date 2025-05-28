import com.jm.thinkup.extension.setNamespace

plugins {
    alias(libs.plugins.tu.android.library)
    alias(libs.plugins.tu.android.compose)
    alias(libs.plugins.kotlin.serialization)
}

android {
    setNamespace("core.navigation")
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
}