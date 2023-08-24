package data.datasource.firebase.core

object Firebase

expect class FirebaseApp {
    val name: String
    val options: FirebaseOptions
    fun delete()
}

/** Returns the default firebase app instance. */
expect val Firebase.app: FirebaseApp

/** Returns a named firebase app instance. */
expect fun Firebase.app(name: String): FirebaseApp

/** Returns all firebase app instances. */
expect fun Firebase.apps(context: Any? = null): List<FirebaseApp>

/** Initializes and returns a FirebaseApp. */
expect fun Firebase.initialize(context: Any? = null): FirebaseApp?

/** Initializes and returns a FirebaseApp. */
expect fun Firebase.initialize(context: Any? = null, options: FirebaseOptions): FirebaseApp

/** Initializes and returns a FirebaseApp. */
expect fun Firebase.initialize(context: Any? = null, options: FirebaseOptions, name: String): FirebaseApp

/** Returns options of default FirebaseApp */
val Firebase.options: FirebaseOptions
    get() = Firebase.app.options

data class FirebaseOptions(
    val applicationId: String,
    val apiKey: String,
    val databaseUrl: String? = null,
    val gaTrackingId: String? = null,
    val storageBucket: String? = null,
    val projectId: String? = null,
    val gcmSenderId: String? = null,
    val authDomain: String? = null
)

expect open class FirebaseException : Exception

expect class FirebaseNetworkException : FirebaseException

expect open class FirebaseTooManyRequestsException : FirebaseException

expect open class FirebaseApiNotAvailableException : FirebaseException
