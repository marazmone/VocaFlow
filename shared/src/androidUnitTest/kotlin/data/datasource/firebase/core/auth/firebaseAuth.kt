@file:JvmName("tests")

package data.datasource.firebase.core.auth

import org.junit.Ignore

actual val emulatorHost: String = "10.0.2.2"

actual val context: Any = ""

actual fun runTest(test: suspend () -> Unit) = kotlinx.coroutines.test.runTest { test() }

// Tests are to be run on AndroidInstrumentedTests.
// Kotlin 1.8 does not allow us to remove the commonTest dependency from AndroidUnitTest
// Therefore we just wont run them
// Kotlin 1.9 will introduce methods for disabling tests properly
actual typealias IgnoreForAndroidUnitTest = Ignore
