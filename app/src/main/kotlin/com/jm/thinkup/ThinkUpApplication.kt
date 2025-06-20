package com.jm.thinkup

import android.app.Application
import com.jm.logutil.LogUtil
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ThinkUpApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        LogUtil.init(this, tag = "JM")
    }
}