package data.datasource.firebase.core.crashlytics

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

object FirebaseCrashlyticsLogger {

    fun initDebugBuild() {
        Napier.base(DebugAntilog())
    }

    fun initReleaseBuild() {
        Napier.base(CrashlyticsAntilog())
    }
}
