package domain.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import data.datasource.firebase.core.Firebase
import data.datasource.firebase.core.crashlytics.crashlytics
import io.github.aakira.napier.Napier
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.AT_MOST_ONCE
import kotlin.contracts.contract
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import presentation.base.BaseViewEffect

@OptIn(ExperimentalContracts::class)
inline fun <T> Result<T>.onFailureWithLog(action: (exception: Throwable) -> Unit): Result<T> {
    contract {
        callsInPlace(action, AT_MOST_ONCE)
    }
    exceptionOrNull()?.let {
        Napier.e(throwable = it, message = it.message.orEmpty())
        Firebase.crashlytics.recordException(it)
        action(it)
    }
    return this
}

@Composable
fun <T> Flow<T>.listen(collector: (effect: T) -> Unit) where T : BaseViewEffect {
    LaunchedEffect(Unit) {
        this@listen.onEach { effect -> collector(effect) }.collect()
    }
}
