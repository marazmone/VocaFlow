package data.model.firebase.auth

data class FirebaseActionCodeSettings(
    val url: String,
    val androidPackageName: FirebaseAuthAndroidPackageName? = null,
    val dynamicLinkDomain: String? = null,
    val canHandleCodeInApp: Boolean = false,
    val iOSBundleId: String? = null
)
