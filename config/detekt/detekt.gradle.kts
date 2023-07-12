buildscript {
    repositories {
        google()
        gradlePluginPortal()
    }

    val detekt by configurations.creating

    val detektTask = tasks.register<JavaExec>("detekt") {
        main = "io.gitlab.arturbosch.detekt.cli.Main"
        classpath = detekt

        val input = projectDir
        val config = "$projectDir/config/detekt/detekt.yml"
        val exclude = ".*/build/.*,.*/resources/.*"
        val params = listOf("-i", input, "-c", config, "-ex", exclude)

        args(params)
    }

    dependencies {
        detekt(libs.detektCli)
        detekt(libs.detektFormat)
    }
}
