package data.datasource.firebase.core.auth

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import platform.Foundation.NSDate
import platform.Foundation.NSDefaultRunLoopMode
import platform.Foundation.NSRunLoop
import platform.Foundation.create
import platform.Foundation.runMode

actual val emulatorHost: String = "localhost"

actual val context: Any = Unit

actual fun runTest(test: suspend () -> Unit) = runBlocking {
    val testRun = MainScope().async { test() }
    while (testRun.isActive) {
        NSRunLoop.mainRunLoop.runMode(
            NSDefaultRunLoopMode,
            beforeDate = NSDate.create(timeInterval = 1.0, sinceDate = NSDate())
        )
        yield()
    }
    testRun.await()
}

actual annotation class IgnoreForAndroidUnitTest()
