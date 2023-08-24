package data.model.firebase.auth

import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

actual class FirebaseAuthUserData internal constructor(private val user: FirebaseUser) {

    actual val uid: String
        get() = user.uid

    actual suspend fun delete() = user.delete().await().run { Unit }
}
