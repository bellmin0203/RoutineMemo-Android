import com.jm.thinkup.extension.setNamespace

plugins {
    alias(libs.plugins.tu.android.library)
}

android {
    setNamespace("core.util")
}

dependencies {
    api(libs.jmlog)
}