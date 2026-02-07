package com.ur.apps.launcher.demo

import android.app.Application
import android.content.Context
import android.view.View
import app.lawnchair.LauncherSDK
import com.ur.apps.sad.UR

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        LauncherSDK.init(this)
        LauncherSDK.onLauncherAppStateCreated(this)

        // 开启负一屏 ，自定义负一屏试图
        LauncherSDK.isOverlayEnabled = true
        LauncherSDK.overlayProvider = object : LauncherSDK.OverlayProvider {
            override fun createView(context: Context): View {
                return CustomOverlayView(context)
            }
        }
        // 渠道信息从tenjin里获取
        UR.init(this, "user-ad-network")
    }
}
