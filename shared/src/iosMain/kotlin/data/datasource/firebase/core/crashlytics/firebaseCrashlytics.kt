package data.datasource.firebase.core.crashlytics

import cocoapods.FirebaseCrashlytics.FIRCrashlytics
import data.datasource.firebase.core.Firebase
import data.datasource.firebase.core.FirebaseException
import platform.Foundation.NSError
import platform.Foundation.NSLocalizedDescriptionKey

actual val Firebase.crashlytics
    get() = FirebaseCrashlytics(FIRCrashlytics.crashlytics())

@Suppress("UNCHECKED_CAST")
actual class FirebaseCrashlytics internal constructor(
    private val crashlytics: FIRCrashlytics
) {

    actual fun recordException(exception: Throwable) {
        crashlytics.recordError(exception.asNSError())
    }

    actual fun log(message: String) {
        crashlytics.log(message)
    }

    actual fun setUserId(userId: String) {
        crashlytics.setUserID(userId)
    }

    actual fun setCrashlyticsCollectionEnabled(enabled: Boolean) {
        crashlytics.setCrashlyticsCollectionEnabled(enabled)
    }

    actual fun sendUnsentReports() {
        crashlytics.sendUnsentReports()
    }

    actual fun deleteUnsentReports() {
        crashlytics.deleteUnsentReports()
    }

    actual fun didCrashOnPreviousExecution(): Boolean {
        return crashlytics.didCrashDuringPreviousExecution()
    }

    actual fun setCustomKey(key: String, value: Any) {
        crashlytics.setCustomValue(key, value.toString())
    }

    actual fun setCustomKeys(customKeys: Map<String, Any>) {
        crashlytics.setCustomKeysAndValues(customKeys as Map<Any?, *>)
    }
}

actual open class FirebaseCrashlyticsException internal constructor(message: String) : FirebaseException(message)

private fun Throwable.asNSError(): NSError {
    val userInfo = mutableMapOf<Any?, Any>()
    userInfo["KotlinException"] = this
    val message = message
    if (message != null) {
        userInfo[NSLocalizedDescriptionKey] = message
    }
    return NSError.errorWithDomain("KotlinException", 0, userInfo)
}
