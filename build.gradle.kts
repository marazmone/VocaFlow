plugins {
    alias(libs.plugins.multiplatform) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.compose)
    alias(libs.plugins.android.kotlin) apply false
    alias(libs.plugins.jvm) apply false
    alias(libs.plugins.nativeCocoapod) apply false
    alias(libs.plugins.google.services) apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

apply {
    from(file("config/detekt/detekt.gradle.kts"))
}
