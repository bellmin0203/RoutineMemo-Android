import com.jm.thinkup.extension.setNamespace

plugins {
    alias(libs.plugins.tu.android.feature)
}

android {
    setNamespace("feature.home")
}

dependencies {
    implementation(libs.kotlinx.immutable)
}