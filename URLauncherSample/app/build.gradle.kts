plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

configurations.all {
    exclude(group = "org.jetbrains.kotlin", module = "kotlin-android-extensions-runtime")
    resolutionStrategy.eachDependency {
        if (requested.group == "org.jetbrains.kotlin") {
            useVersion("2.1.0")
        }
    }
}

android {
    namespace = "com.ur.apps.launcher.demo"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.ur.apps.launcher.demo"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
            storeFile = file("release-key.jks")
            storePassword = "android"
            keyAlias = "key0"
            keyPassword = "android"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs += "-Xskip-metadata-version-check"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    implementation("com.lawnchair:launcher-sdk:1.0.14") {
        exclude(group = "com.github.samanzamani", module = "PersianDate")
    }
    // 数数
    implementation("cn.thinkingdata.android:ThinkingAnalyticsSDK:3.0.2")
    // Admob 广告相关
    implementation("com.google.android.gms:play-services-ads:23.6.0")
    implementation("androidx.ads:ads-identifier:1.0.0-alpha01")
    implementation("com.google.guava:guava:28.0-android")
    //Vungle
    implementation("com.vungle:vungle-ads:7.4.3")
    implementation("com.google.android.gms:play-services-basement:18.1.0")
    implementation("com.google.android.gms:play-services-ads-identifier:18.0.1")
    //Bigo
    implementation("com.bigossp:bigo-ads:5.5.2")
    //Pangle
    implementation("com.google.android.gms:play-services-ads-identifier:18.0.1")
    //Facebook
    implementation("com.facebook.android:audience-network-sdk:6.18.0")

    //Inmobi
    implementation("com.inmobi.monetization:inmobi-ads-kotlin:10.8.0")
    //AppLovin
    implementation("com.applovin:applovin-sdk:13.1.0")
    implementation("com.applovin:applovin-sdk:+")
    //Mintegral
    implementation("com.mbridge.msdk.oversea:mbridge_android_sdk:16.9.11")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    //Chartboost
    implementation("com.chartboost:chartboost-sdk:9.8.2")
    implementation("com.chartboost:chartboost-mediation-sdk:4.9.2")
    implementation("com.chartboost:chartboost-mediation-adapter-chartboost:4.9.8.1.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    //Yandex
    implementation("com.yandex.android:mobileads:7.10.0")
    //Fyber
    implementation("com.fyber:marketplace-sdk:8.3.5")
    implementation("com.google.android.gms:play-services-ads-identifier:18.0.1")
    // add firebase
    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:34.5.0"))
    // When using the BoM, you don't specify versions in Firebase library dependencies
    // Add the dependency for the Firebase SDK for Google Analytics
    implementation("com.google.firebase:firebase-analytics")
    // TODO: Add the dependencies for any other Firebase products you want to use
    // See https://firebase.google.com/docs/android/setup#available-libraries
    // For example, add the dependencies for Firebase Authentication and Cloud Firestore
//    implementation("com.google.firebase:firebase-auth")
//    implementation("com.google.firebase:firebase-firestore")

    // admob mediation adapter
    implementation("com.google.ads.mediation:facebook:6.21.0.0")
    implementation("com.unity3d.ads:unity-ads:4.16.2")
    implementation("com.google.ads.mediation:unity:4.16.5.0")
    implementation("com.google.ads.mediation:vungle:7.6.2.0")
    implementation("com.google.ads.mediation:chartboost:9.10.2.0")
    implementation("com.google.ads.mediation:fyber:8.4.1.0")
    implementation("com.google.ads.mediation:ironsource:9.2.0.0")
    implementation("com.google.ads.mediation:pangle:7.8.0.8.0")
    implementation("com.google.ads.mediation:mintegral:17.0.41.0")
    implementation("com.google.ads.mediation:inmobi:11.1.0.0")

}