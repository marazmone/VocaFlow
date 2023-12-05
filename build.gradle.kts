plugins {
    alias(libs.plugins.multiplatform) apply false
    alias(libs.plugins.serialization) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.compose) apply false
    alias(libs.plugins.android.kotlin) apply false
    alias(libs.plugins.jvm) apply false
    alias(libs.plugins.nativeCocoapod) apply false
    alias(libs.plugins.google.services) apply false
    alias(libs.plugins.firebase.crashlytics) apply false
    alias(libs.plugins.detekt) apply true
}

subprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }

    detekt {
        toolVersion = "1.23.4"
        source = files("src/main/java")
        config = files("$rootDir/detekt.yml")
        parallel = true
        autoCorrect = true
    }

    tasks.detekt {
        jvmTarget = libs.versions.jdk.get()
        reports {
            xml {
                required.set(true)
                outputLocation.set(file("build/reports/detekt.xml"))
            }
            html {
                required.set(true)
                outputLocation.set(file("build/reports/detekt.html"))
            }
        }
    }
}
