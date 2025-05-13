import com.jm.routinememo.extension.setNamespace

plugins {
    alias(libs.plugins.rm.android.library)
}

android {
    setNamespace("core.model")
}

dependencies {
    api(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)
}