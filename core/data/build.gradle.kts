import com.jm.thinkup.extension.setNamespace

plugins {
    alias(libs.plugins.tu.android.library)
    alias(libs.plugins.tu.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    setNamespace("core.data")
}

dependencies {
    implementation(projects.core.datastore)
    implementation(projects.core.database)
    implementation(projects.core.domain)

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)
}