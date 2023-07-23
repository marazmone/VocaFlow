package data.datasource.firebase.core.crashlytics

import data.datasource.firebase.core.Firebase
import data.datasource.firebase.core.FirebaseException

expect val Firebase.crashlytics: FirebaseCrashlytics

expect class FirebaseCrashlytics {
    fun recordException(exception: Throwable)

    fun log(message: String)

    fun setUserId(userId: String)

    fun setCustomKey(key: String, value: Any)

    fun setCustomKeys(customKeys: Map<String, Any>)

    fun setCrashlyticsCollectionEnabled(enabled: Boolean)

    fun didCrashOnPreviousExecution(): Boolean

    fun sendUnsentReports()

    fun deleteUnsentReports()
}

expect open class FirebaseCrashlyticsException : FirebaseException
