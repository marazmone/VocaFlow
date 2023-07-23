package data.datasource.firebase.core.crashlytics

import data.datasource.firebase.core.Firebase
import io.github.aakira.napier.Antilog
import io.github.aakira.napier.LogLevel

actual class CrashlyticsAntilog : Antilog() {

    override fun performLog(priority: LogLevel, tag: String?, throwable: Throwable?, message: String?) {
        // send only error log
        if (priority < LogLevel.ERROR) return
        Firebase.crashlytics.log("$tag: $message")
        throwable?.let { Firebase.crashlytics.recordException(it) }
    }
}
