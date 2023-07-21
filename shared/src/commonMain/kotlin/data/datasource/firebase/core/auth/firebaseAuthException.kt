package data.datasource.firebase.core.auth

import data.datasource.firebase.core.FirebaseException

expect open class FirebaseAuthException : FirebaseException

expect class FirebaseAuthUserCollisionException : FirebaseAuthException
