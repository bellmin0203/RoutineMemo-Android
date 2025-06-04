import com.jm.thinkup.extension.setNamespace

plugins {
    alias(libs.plugins.tu.android.library)
    alias(libs.plugins.tu.android.hilt)
}

android {
    setNamespace("core.common")
}