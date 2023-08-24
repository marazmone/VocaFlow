package data.datasource.firebase.core.auth

import data.datasource.firebase.core.Firebase
import data.datasource.firebase.core.FirebaseOptions
import data.datasource.firebase.core.apps
import data.datasource.firebase.core.initialize
import kotlin.random.Random
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

expect val emulatorHost: String

expect val context: Any

expect fun runTest(test: suspend () -> Unit)

expect annotation class IgnoreForAndroidUnitTest constructor()

@IgnoreForAndroidUnitTest
class FirebaseAuthTest {

    @BeforeTest
    fun initializeFirebase() {
        Firebase
            .takeIf { Firebase.apps(context).isEmpty() }
            ?.apply {
                initialize(
                    context,
                    FirebaseOptions(
                        applicationId = "1:355113102526:android:b571b9108b4d58a4e542ef",
                        apiKey = "AIzaSyB72d79VE9BMZLYMUJLeirVnbqpqj-55no",
                    )
                )
                Firebase.auth.useEmulator(emulatorHost, 9099)
            }
    }

    @Test
    fun testLoginWithEmailAndPassword() = runTest {
        val uid = getTestUid("test@gmail.com", "test123")
        val result = Firebase.auth.loginWithEmailAndPassword("test@gmail.com", "test123")
        assertEquals(uid, result.user!!.uid)
    }

    @Test
    fun testCreateUserWithEmailAndPassword() = runTest {
        val email = "test+${Random.nextInt(100)}@gmail.com"
        val createResult = Firebase.auth.createUserWithEmailAndPassword(email, "test123")
        assertNotEquals(null, createResult.user?.uid)

        val signInResult = Firebase.auth.loginWithEmailAndPassword(email, "test123")
        assertEquals(createResult.user?.uid, signInResult.user?.uid)

        signInResult.user!!.delete()
    }

    @Test
    fun sendPasswordResetEmail() = runTest {
        val email = "test+${Random.nextInt(100)}@gmail.com"
        val createResult = Firebase.auth.createUserWithEmailAndPassword(email, "test123")
        assertNotEquals(null, createResult.user?.uid)
        Firebase.auth.sendPasswordResetEmail(email)

        createResult.user!!.delete()
    }

    private suspend fun getTestUid(email: String, password: String): String {
        val uid = Firebase.auth.let {
            val user = try {
                it.createUserWithEmailAndPassword(email, password).user
            } catch (e: FirebaseAuthUserCollisionException) {
                it.loginWithEmailAndPassword(email, password).user
            }
            user!!.uid
        }

        check(Firebase.auth.currentUser != null)
        Firebase.auth.logout()
        check(Firebase.auth.currentUser == null)

        return uid
    }
}
