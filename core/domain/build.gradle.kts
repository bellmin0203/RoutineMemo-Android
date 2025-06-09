plugins {
    alias(libs.plugins.tu.kotlin.library)
    alias(libs.plugins.kotlin.serialization)
}

dependencies {
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.javax.inject)
}