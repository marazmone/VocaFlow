@file:JvmName("tests")

package data.datasource.firebase.core.auth

import androidx.test.platform.app.InstrumentationRegistry

actual val emulatorHost: String = "10.0.2.2"

actual val context: Any = InstrumentationRegistry.getInstrumentation().targetContext

actual fun runTest(test: suspend () -> Unit) = kotlinx.coroutines.test.runTest { test() }

actual annotation class IgnoreForAndroidUnitTest()
