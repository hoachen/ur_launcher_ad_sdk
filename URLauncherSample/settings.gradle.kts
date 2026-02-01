pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        maven {
            url = uri("https://cboost.jfrog.io/artifactory/chartboost-ads/")
        }
        maven {
            url = uri("https://android-sdk.is.com/")
        }
        maven {
            url = uri("https://artifact.bytedance.com/repository/pangle/")
        }
        maven {
            url = uri("https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea")
        }
        mavenCentral()

        //Anythink(Core)
        maven {
            url  = uri("https://jfrog.anythinktech.com/artifactory/overseas_sdk")
        }

        //Pangle
        maven {
            url = uri( "https://artifact.bytedance.com/repository/pangle")
        }

        //Mintegral
        maven {
            url = uri( "https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea")
        }

        //Chartboost
        maven {
            url = uri("https://cboost.jfrog.io/artifactory/chartboost-ads")
        }
        maven {
            url = uri("https://cboost.jfrog.io/artifactory/chartboost-mediation")
        }
        maven {
            url = uri("https://jfrog.anythinktech.com/artifactory/debugger")
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        maven {
            url = uri(rootDir.resolve("repo"))
        }
        maven {
            url = uri("https://cboost.jfrog.io/artifactory/chartboost-ads/")
        }
        maven {
            url = uri("https://android-sdk.is.com/")
        }
        maven {
            url = uri("https://artifact.bytedance.com/repository/pangle/")
        }
        maven {
            url = uri("https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea")
        }
        mavenCentral()

        //Anythink(Core)
        maven {
            url  = uri("https://jfrog.anythinktech.com/artifactory/overseas_sdk")
        }

        //Pangle
        maven {
            url = uri( "https://artifact.bytedance.com/repository/pangle")
        }

        //Mintegral
        maven {
            url = uri( "https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea")
        }

        //Chartboost
        maven {
            url = uri("https://cboost.jfrog.io/artifactory/chartboost-ads")
        }
        maven {
            url = uri("https://cboost.jfrog.io/artifactory/chartboost-mediation")
        }
        maven {
            url = uri("https://jfrog.anythinktech.com/artifactory/debugger")
        }
    }
}

rootProject.name = "URLauncherSample"
include(":app")
 