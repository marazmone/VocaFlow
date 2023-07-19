# VocaFlow

[![Kotlin Version](https://img.shields.io/badge/Kotlin-1.8.20-blue.svg)](https://kotlinlang.org)
[![AGP](https://img.shields.io/badge/AGP-7.4.+-blue?style=flat)](https://developer.android.com/studio/releases/gradle-plugin)
[![Gradle](https://img.shields.io/badge/Gradle-7.5.+-blue?style=flat)](https://gradle.org)

**VocaFlow** is a powerful language learning application built using Kotlin Multiplatform technology. Designed to assist language learners in expanding their vocabulary, VocaFlow provides an immersive and interactive experience for users to learn words and phrases in various languages.

With VocaFlow, language learners can explore a wide range of languages and effortlessly build their vocabulary through engaging exercises and interactive quizzes. The application leverages the Kotlin Multiplatform framework, allowing it to run seamlessly on multiple platforms, including Android, iOS.

Language Diversity: VocaFlow offers an extensive collection of languages to learn from, catering to both popular languages and niche dialects. Users can choose their desired language pairings and easily switch between them to broaden their linguistic horizons.

Vocabulary Expansion: VocaFlow provides users with a comprehensive database of words and phrases specific to each language. Through intuitive exercises and quizzes, learners can practice and reinforce their understanding of vocabulary in context.

## Application Scope

### Intro Flow
|<img width="375" alt="splash-screen" src="https://github.com/marazmone/VocaFlow/assets/7988862/caaab165-9a79-4c10-80d0-b08c0645a13a">|<img width="375" alt="intro-screen-1" src="https://github.com/marazmone/VocaFlow/assets/7988862/3128dd33-ac87-4d46-acd4-73566fccf74e">|<img width="375" alt="intro-screen-2" src="https://github.com/marazmone/VocaFlow/assets/7988862/7500dbdd-9664-4167-9a30-b60bee223dd2">|<img width="375" alt="intro-screen-3" src="https://github.com/marazmone/VocaFlow/assets/7988862/9e93ac5f-e1b0-46da-b776-8b1973f620ae">|
|--|--|--|--|

### Auth Flow
|<img width="375" alt="auth-screen-1" src="https://github.com/marazmone/VocaFlow/assets/7988862/c86339ba-9df5-43b7-b417-2838a38c40fc">|<img width="375" alt="auth-screen-2" src="https://github.com/marazmone/VocaFlow/assets/7988862/6d04aa2a-c8be-4d92-a17f-763fbdb06003">|<img width="375" alt="auth-screen-3" src="https://github.com/marazmone/VocaFlow/assets/7988862/7b28906e-6fca-4981-96b2-24fd454f9455">|
|--|--|--|

## Tech-Stack

-   Tech-stack
    -   [100% Kotlin](https://kotlinlang.org/)
        -   [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)  - perform background operations
        -   [Kotlin Flow](https://kotlinlang.org/docs/flow.html)  - data flow across all app layers, including views
        -   [Kotlin multiplatform](https://kotlinlang.org/docs/multiplatform.html)  - The Kotlin Multiplatform technology is designed to simplify the development of cross-platform projects.
        -  [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/) - Develop stunning shared UIs for Android, iOS, desktop, and web.
    -   [Koin](https://insert-koin.io/)  - dependency injection (dependency retrieval)
    -   [Voyager](https://voyager.adriel.cafe/)  - A  multiplatform navigation library built for, and seamlessly integrated with, Jetpack Compose
-   Modern Architecture
    -   [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
-   UI
    -   [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)  - Develop stunning shared UIs for Android, iOS, desktop, and web.
    -   [Material Design 3](https://m3.material.io/)  - application design system providing UI components
-   CI
    ...
-   Testing
    ...
-   Static analysis tools (linters)
    -   [Detekt](https://github.com/arturbosch/detekt#with-gradle)  - verify code complexity and code smells
-   Gradle
    -   [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)  - define build scripts
    -   [Versions catalog](https://docs.gradle.org/current/userguide/platforms.html#sub:version-catalog)  - define dependencies
-   GitHub Boots

## Architecture

### Layears

![architecture](https://github.com/marazmone/VocaFlow/assets/7988862/f8fa65ef-6523-4556-a456-4b339792c935)

## To be continue...