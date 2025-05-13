import com.jm.routinememo.extension.setNamespace

plugins {
    alias(libs.plugins.rm.android.feature)
}

android {
    setNamespace("feature.home")
}