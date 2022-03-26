package com.robin.wiser_wrtc

import android.app.Application
import com.sendbird.calls.SendBirdCall
import com.robin.wiser_wrtc.util.SharedPreferencesManager

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SendBirdCall.setLoggerLevel(SendBirdCall.LOGGER_INFO)
        SharedPreferencesManager.init(applicationContext)
    }
}
