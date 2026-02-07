package com.ur.apps.launcher.demo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
// Removed invalid imports
// import app.lawnchair.ui.theme.EdgeToEdge
// import app.lawnchair.ui.theme.LawnchairTheme
 import com.ur.chair.walk.LauncherSettingManager

class SplashActivity : ComponentActivity() {

    private val handler = Handler(Looper.getMainLooper())
    private var navigated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            // Replaced LawnchairTheme with MaterialTheme
            MaterialTheme {
                // Removed EdgeToEdge() composable call as it was unresolved
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.surface) {
                    val transition = rememberInfiniteTransition()
                    val scale by transition.animateFloat(
                        initialValue = 0.96f,
                        targetValue = 1.04f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(durationMillis = 1200, easing = FastOutSlowInEasing),
                            repeatMode = RepeatMode.Reverse,
                        ),
                    )
                    val rotation by transition.animateFloat(
                        initialValue = -3f,
                        targetValue = 3f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(durationMillis = 2200, easing = FastOutSlowInEasing),
                            repeatMode = RepeatMode.Reverse,
                        ),
                    )
                    val translateY by transition.animateFloat(
                        initialValue = -6f,
                        targetValue = 6f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(durationMillis = 1600, easing = FastOutSlowInEasing),
                            repeatMode = RepeatMode.Reverse,
                        ),
                    )
                    val elevationPx = with(LocalDensity.current) { 12.dp.toPx() }
                    var textTarget by remember { mutableStateOf(0f) }
                    LaunchedEffect(Unit) { textTarget = 1f }
                    val textAlpha by animateFloatAsState(
                        targetValue = textTarget,
                        animationSpec = tween(durationMillis = 700, easing = FastOutSlowInEasing),
                    )
                    val activity = this@SplashActivity
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = null,
                            modifier = Modifier
                                .size(108.dp)
                                .graphicsLayer {
                                    shape = CircleShape
                                    clip = true
                                    shadowElevation = elevationPx
                                    rotationZ = rotation
                                    translationY = translateY
                                    scaleX = scale
                                    scaleY = scale
                                },
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = stringResource(id = R.string.app_name),
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.alpha(textAlpha),
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Button(
                                onClick = {
                                     // Placeholder for Launcher Setting Manager
                                    LauncherSettingManager.openLauncherChooser(
                                        this@SplashActivity)
                                },
                                shape = RoundedCornerShape(24.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    contentColor = MaterialTheme.colorScheme.onPrimary,
                                ),
                            ) {
                                Text(text = "跳转到启动器")
                            }
                            Button(
                                onClick = {
                                    checkOverlayPermission()
                                },
                                shape = RoundedCornerShape(24.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                ),
                            ) {
                                Text(text = "引导悬浮窗权限")
                            }
                            Button(
                                onClick = {},
                                shape = RoundedCornerShape(24.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                    contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                                ),
                            ) {
                                Text(text = "按钮3")
                            }
                        }
                    }
                }
            }
        }

        handler.postDelayed({
            if (!navigated) {
                navigated = true

            }
        }, 3000)
    }


    /**
     * 检查并跳转悬浮窗权限设置页面
     */
    private fun checkOverlayPermission() {
        if (!Settings.canDrawOverlays(this)) {
            val intent = Intent(
                Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                Uri.parse("package:$packageName")
            )
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}
