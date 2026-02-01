# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# ================= Lawnchair SDK ProGuard Rules =================

# 1. Core SDK Classes
-keep class app.lawnchair.** { *; }
-keep class com.android.launcher3.** { *; }

# 2. Protocol Buffers (Internal usage)
-keep class com.google.protobuf.** { *; }

# 3. Network (Retrofit & OkHttp)
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions
-dontwarn okhttp3.**
-keep class okhttp3.** { *; }

# 4. Database (Room)
-keep class androidx.room.** { *; }
-dontwarn androidx.room.paging.**

# 5. Missing libraries (Excluded intentionally or R8 false positives)
-dontwarn saman.zamani.persiandate.**
-dontwarn kotlin.time.**
-dontwarn kotlinx.serialization.**
-dontwarn com.skydoves.balloon.**
-dontwarn com.android.**
-dontwarn android.**



# The rules from AOSP are located in proguard.flags file, we can just maintain Lawnchair related rules here.

# Optimization options.
-allowaccessmodification
-dontoptimize
-dontpreverify
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose
-keepattributes InnerClasses, *Annotation*, Signature, SourceFile, LineNumberTable


# This is generated automatically by the Android Gradle plugin.
-dontwarn android.appwidget.AppWidgetHost$AppWidgetHostListener
-dontwarn android.util.StatsEvent$Builder
-dontwarn android.util.StatsEvent
-dontwarn androidx.window.extensions.**
-dontwarn androidx.window.sidecar.**
-dontwarn com.android.org.conscrypt.TrustManagerImpl
-dontwarn com.android.wm.shell.**
-dontwarn com.skydoves.balloon.**
-dontwarn dalvik.system.CloseGuard
-dontwarn lineageos.providers.LineageSettings$System
-dontwarn androidx.compose.runtime.PrimitiveSnapshotStateKt
-dontwarn androidx.renderscript.Allocation
-dontwarn androidx.renderscript.BaseObj
-dontwarn androidx.renderscript.Element
-dontwarn androidx.renderscript.FieldPacker
-dontwarn androidx.renderscript.RSRuntimeException
-dontwarn androidx.renderscript.RenderScript
-dontwarn androidx.renderscript.Script$LaunchOptions
-dontwarn androidx.renderscript.ScriptC
-dontwarn androidx.renderscript.ScriptIntrinsicBlur
-dontwarn androidx.renderscript.Type


# Common rules.
-keep class com.android.** { *; }
-keep class android.window.** { *; }
-keepclasseswithmembernames class * {
    native <methods>;
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
-keepclassmembers class * implements android.os.Parcelable {
  public static final ** CREATOR;
}

# Lawnchair specific rules.
-keep class app.lawnchair.LawnchairProto$* { *; }
-keep class app.lawnchair.LawnchairApp { *; }
-keep class app.lawnchair.LawnchairLauncher { *; }
-keep class app.lawnchair.compatlib.** { *; }
-keep class android.view.** { *; }

-keep class com.google.protobuf.Timestamp { *; }

# TODO: Remove this after the change in https://github.com/ChickenHook/RestrictionBypass/pull/9 has been released.
-keep class org.chickenhook.restrictionbypass.** { *; }
