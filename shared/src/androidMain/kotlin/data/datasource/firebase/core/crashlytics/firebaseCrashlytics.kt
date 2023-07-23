package data.datasource.firebase.core.crashlytics

import com.google.firebase.crashlytics.FirebaseCrashlytics as MainFirebaseCrashlytics
import com.google.firebase.FirebaseException
import com.google.firebase.crashlytics.CustomKeysAndValues.Builder
import data.datasource.firebase.core.Firebase

actual val Firebase.crashlytics: FirebaseCrashlytics
    get() = FirebaseCrashlytics(MainFirebaseCrashlytics.getInstance())

actual class FirebaseCrashlytics internal constructor(
    private val crashlytics: MainFirebaseCrashlytics
) {

    actual fun recordException(exception: Throwable) {
        crashlytics.recordException(exception)
    }

    actual fun log(message: String) {
        crashlytics.log(message)
    }

    actual fun setUserId(userId: String) {
        crashlytics.setUserId(userId)
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
        return crashlytics.didCrashOnPreviousExecution()
    }

    actual fun setCustomKey(key: String, value: Any) {
        when (value) {
            is Boolean -> crashlytics.setCustomKey(key, value)
            is Double -> crashlytics.setCustomKey(key, value)
            is Float -> crashlytics.setCustomKey(key, value)
            is Int -> crashlytics.setCustomKey(key, value)
            is Long -> crashlytics.setCustomKey(key, value)
            else -> crashlytics.setCustomKey(key, value.toString())
        }
    }

    actual fun setCustomKeys(customKeys: Map<String, Any>) =
        crashlytics.setCustomKeys(
            Builder().apply {
                customKeys.forEach { (key, value) ->
                    when (value) {
                        is String -> putString(key, value)
                        is Boolean -> putBoolean(key, value)
                        is Double -> putDouble(key, value)
                        is Float -> putFloat(key, value)
                        is Int -> putInt(key, value)
                        is Long -> putLong(key, value)
                    }
                }
            }.build()
        )
}

actual open class FirebaseCrashlyticsException(message: String) : FirebaseException(message)
