import com.jm.routinememo.extension.setNamespace

plugins {
    alias(libs.plugins.rm.android.library)
}

android {
    setNamespace("core.datastore")
}

dependencies {
    implementation(libs.androidx.dataStore)
}