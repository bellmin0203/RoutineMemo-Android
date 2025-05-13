import com.jm.routinememo.extension.setNamespace

plugins {
    alias(libs.plugins.rm.android.library)
    alias(libs.plugins.rm.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    setNamespace("core.data")
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.datastore)

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)
}