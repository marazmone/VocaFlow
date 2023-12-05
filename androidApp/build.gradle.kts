plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose)
    alias(libs.plugins.google.services)
    alias(libs.plugins.firebase.crashlytics)
}

kotlin {
    androidTarget()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(project(":shared"))

                // Koin
                implementation(libs.koin.core)
                implementation(libs.koin.android)
            }
        }
    }
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()
    namespace = "com.vocaflow.android"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        applicationId = "com.vocaflow.android"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.compileSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.5"
    }
    kotlin {
        jvmToolchain(libs.versions.jdk.get().toInt())
    }
}
