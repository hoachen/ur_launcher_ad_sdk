package com.example.mydemo

import android.app.Application
import app.lawnchair.LauncherSDK

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        LauncherSDK.init(this)
        LauncherSDK.onLauncherAppStateCreated(this)
        
        LauncherSDK.isOverlayEnabled = true
        LauncherSDK.overlayProvider = object : LauncherSDK.OverlayProvider {
            override fun createView(context: android.content.Context): android.view.View {
                return CustomOverlayView(context)
            }
        }
    }
}
