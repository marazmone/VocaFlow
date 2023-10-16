package data.datasource.firebase.core.crashlytics

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.crashlytics.crashlytics
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
