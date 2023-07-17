package di.usecase

import domain.usecase.firebase.auth.FirebaseAuthCreateUserWithEmailUseCase
import domain.usecase.firebase.auth.FirebaseAuthGetCurrentUserUseCase
import domain.usecase.firebase.auth.FirebaseAuthLoginWithEmailUseCase
import domain.usecase.firebase.auth.FirebaseAuthLogoutUseCase
import domain.usecase.firebase.auth.FirebaseAuthResetPasswordByEmailUseCase
import org.koin.dsl.module

fun firebaseUseCaseModule() = module {
    factory { FirebaseAuthGetCurrentUserUseCase(get()) }
    factory { FirebaseAuthCreateUserWithEmailUseCase(get()) }
    factory { FirebaseAuthLogoutUseCase(get()) }
    factory { FirebaseAuthLoginWithEmailUseCase(get()) }
    factory { FirebaseAuthResetPasswordByEmailUseCase(get()) }
}
