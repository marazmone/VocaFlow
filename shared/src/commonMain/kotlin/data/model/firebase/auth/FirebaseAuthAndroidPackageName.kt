package data.model.firebase.auth

data class FirebaseAuthAndroidPackageName(
    val packageName: String,
    val installIfNotAvailable: Boolean = true,
    val minimumVersion: String? = null
)
