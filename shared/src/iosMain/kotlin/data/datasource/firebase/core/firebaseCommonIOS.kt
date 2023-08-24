package data.datasource.firebase.core

import cocoapods.FirebaseCore.FIRApp
import cocoapods.FirebaseCore.FIROptions
import data.datasource.firebase.core.auth.toException
import kotlinx.coroutines.CompletableDeferred
import platform.Foundation.NSError

actual open class FirebaseException(message: String) : Exception(message)

actual open class FirebaseNetworkException(message: String) : FirebaseException(message)

actual open class FirebaseTooManyRequestsException(message: String) : FirebaseException(message)

actual open class FirebaseApiNotAvailableException(message: String) : FirebaseException(message)

actual val Firebase.app: FirebaseApp
    get() = FirebaseApp(FIRApp.defaultApp()!!)

actual fun Firebase.app(name: String): FirebaseApp =
    FirebaseApp(FIRApp.appNamed(name)!!)

actual fun Firebase.initialize(context: Any?): FirebaseApp? =
    FIRApp.configure().let { app }

actual fun Firebase.initialize(context: Any?, options: FirebaseOptions, name: String): FirebaseApp =
    FIRApp.configureWithName(name, options.toIos()).let { app(name) }

actual fun Firebase.initialize(context: Any?, options: FirebaseOptions) =
    FIRApp.configureWithOptions(options.toIos()).let { app }

actual class FirebaseApp internal constructor(val ios: FIRApp) {
    actual val name: String
        get() = ios.name
    actual val options: FirebaseOptions
        get() = ios.options.run {
            FirebaseOptions(
                bundleID,
                APIKey!!,
                databaseURL!!,
                trackingID,
                storageBucket,
                projectID
            )
        }

    actual fun delete() = Unit
}

actual fun Firebase.apps(context: Any?) = FIRApp.allApps()
    .orEmpty()
    .values
    .map { FirebaseApp(it as FIRApp) }

private fun FirebaseOptions.toIos() = FIROptions(this@toIos.applicationId, this@toIos.gcmSenderId ?: "")
    .apply {
        APIKey = this@toIos.apiKey
        databaseURL = this@toIos.databaseUrl
        trackingID = this@toIos.gaTrackingId
        storageBucket = this@toIos.storageBucket
        projectID = this@toIos.projectId
    }

internal suspend inline fun <T> T.await(function: T.(callback: (NSError?) -> Unit) -> Unit) {
    val job = CompletableDeferred<Unit>()
    function { error ->
        if (error == null) {
            job.complete(Unit)
        } else {
            job.completeExceptionally(error.toException())
        }
    }
    job.await()
}

internal suspend inline fun <T, reified R> T.awaitResult(function: T.(callback: (R?, NSError?) -> Unit) -> Unit): R {
    val job = CompletableDeferred<R?>()
    function { result, error ->
        if (error == null) {
            job.complete(result)
        } else {
            job.completeExceptionally(error.toException())
        }
    }
    return job.await() as R
}
