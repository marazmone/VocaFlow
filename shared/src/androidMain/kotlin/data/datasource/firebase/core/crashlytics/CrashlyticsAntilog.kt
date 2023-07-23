package data.datasource.firebase.core.crashlytics

import data.datasource.firebase.core.Firebase
import io.github.aakira.napier.Antilog
import io.github.aakira.napier.LogLevel

actual class CrashlyticsAntilog : Antilog() {

    override fun performLog(
        priority: LogLevel,
        tag: String?,
        throwable: Throwable?,
        message: String?
    ) {
        if (priority < LogLevel.ERROR) return
        throwable?.also { Firebase.crashlytics.recordException(it) }
    }
}
