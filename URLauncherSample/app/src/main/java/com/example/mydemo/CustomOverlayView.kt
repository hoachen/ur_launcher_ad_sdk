package com.example.mydemo

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.TextView

/**
 * 自定义负一屏内容
 */
class CustomOverlayView(context: Context) : FrameLayout(context) {
    init {
        setBackgroundColor(Color.LTGRAY)
        
        val textView = TextView(context).apply {
            text = "Minus One Screen"
            textSize = 24f
            setTextColor(Color.BLACK)
            gravity = Gravity.CENTER
        }
        
        addView(textView, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT))
    }
}
