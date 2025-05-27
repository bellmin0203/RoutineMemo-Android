import com.jm.thinkup.extension.setNamespace

plugins {
    alias(libs.plugins.tu.android.library)
    alias(libs.plugins.tu.android.room)
}

android {
    setNamespace("core.database")
}

dependencies {
    // api -> 해당 모듈의 외부에서도 접근 가능
    // implementation -> 해당 모듈 내부에서만 사용 가능
    api(projects.core.model)
}