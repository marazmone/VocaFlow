# VocaFlow

VocaFlow is a powerful language learning application built using Kotlin Multiplatform technology. Designed to assist language learners in expanding their vocabulary, VocaFlow provides an immersive and interactive experience for users to learn words and phrases in various languages.

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

#### To be continue...

## Tech-Stack

-   Tech-stack
    -   [100% Kotlin](https://kotlinlang.org/)
        -   [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)  - perform background operations
        -   [Kotlin Flow](https://kotlinlang.org/docs/flow.html)  - data flow across all app layers, including views
        -   [Kotlin multiplatform](https://kotlinlang.org/docs/multiplatform.html)  - The Kotlin Multiplatform technology is designed to simplify the development of cross-platform projects.
        -  [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/) - Develop stunning shared UIs for Android, iOS, desktop, and web.
    -   [Koin](https://insert-koin.io/)  - dependency injection (dependency retrieval)
    -   [Voyager](https://voyager.adriel.cafe/)  - A  multiplatform navigation library built for, and seamlessly integrated with, Jetpack Compose
    -   [Napier](https://github.com/AAkira/Napier)  - Napier is a logger library for Kotlin Multiplatform
    -   [InsetX](https://github.com/mori-atsushi/insetsx)  - InsetX is a Kotlin Multiplatform library for managing window insets
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
    ...

## Architecture

### Layers

![architecture](https://github.com/marazmone/VocaFlow/assets/7988862/f8fa65ef-6523-4556-a456-4b339792c935)

#### Presentation Layer

This layer is closest to what the user sees on the screen.

The `presentation` layer uses `MVI` pattern.

`MVI`  -  `action`  modifies the  `common UI state`  and emits a new state to a view via  `MutableState`

> The `common state` is a single source of truth for each view. This solution derives from [Unidirectional Data Flow](https://en.wikipedia.org/wiki/Unidirectional_Data_Flow_(computer_science)) and [Redux principles](https://redux.js.org/introduction/three-principles).

Components:

-   **View (Composable Function)**  - observes common view state (through  `MutableState`). Pass user interactions to  `ViewModel`. Views are hard to test, so they should be as simple as possible.
-   **ViewModel**  - emits (through  `MutableState`) view state changes to the view and deals with user interactions (these view models are not simply  [POJO classes](https://en.wikipedia.org/wiki/Plain_old_Java_object)).
-   **UIModel** - sometimes you may not have enough DomainModel to display UI states. For this purpose, the UIModel will be used, supplementing the domain model with the necessary attributes.
-   **Mapper**  - maps  `domain model`  to  `ui model`  (to keep  `presentation`  layer independent from the  `domain`  layer).
-   **State**  - data class that holds the state content of the corresponding screen e.g. list of `User`, loading status etc. The state is exposed as a Compose runtime `MutableState` object from that perfectly matches the use-case of receiving continuous updates with initial value.
-   **Action**  - plain object that is sent through `ViewModel` to the `reducer`. Actions should reflect UI events caused by the user. Actions provide by `reducer` and should update state.

For example(`ViewModel`):

```kotlin
...
	override fun setInitialState(): State = State()
    
	override fun onReduceState(action: Action): State = when (action) {  
		is Loading -> currentState.copy(  
			isLoading = true,  
			isError = false,  
		)  
      
		is GetCurrentUser -> currentState.copy(  
			isLoading = false,  
			isError = false,  
			currentUser = action.currentUser,  
		)  
      
		is Action.Error -> currentState.copy(  
			isLoading = false,  
			isError = true,  
			errorMessage = action.errorMessage,  
		)  
	}
...
```

-   **Effect**  - plain object that signals one-time side-effect actions that should impact the UI e.g. triggering a navigation action, showing a Toast, SnackBar etc. Effects are exposed as  `ChannelFlow`  which behave as in each event is delivered to a single subscriber. An attempt to post an event without subscribers will suspend as soon as the channel buffer becomes full, waiting for a subscriber to appear.

Every **screen** defines its own **contract class** that states all corresponding core components described above: **state**, **actions** and **effects**.

For example:

```kotlin
class FirebaseTestContract {  
      
	data class State(  
		val currentUser: FirebaseUser? = null,  
		val isLoading: Boolean = false,  
		val isError: Boolean = false,  
		val errorMessage: String = "",  
	) : BaseViewState  
      
	sealed interface Action : BaseViewAction {  
      
		object Loading : Action  
      
		data class GetCurrentUser(val currentUser: FirebaseUser?) : Action  
      
		data class Error(val errorMessage: String) : Action  
	}  
      
	sealed interface Effect : BaseViewEffect {  
      
		object NavigationBack : Effect  
	}  
}
```

#### Domain Layer

-   **UseCase**  - contains business logic
-   **DomainModel**  - defines the core structure of the data that will be used within the application. This is the source of truth for application data.
-   **Repository interface**  - required to keep the  `domain`  layer independent from the  `data layer`  ([Dependency inversion](https://en.wikipedia.org/wiki/Dependency_inversion_principle)).

#### Data Layer

Encapsulates application data. Provides the data to the  `domain`  layer eg. retrieves data from the internet and cache the data in disk cache (when the device is offline).

Components:

-   **Repository**  is exposing data to the  `domain`  layer. Depending on the application structure and quality of the external API repository can also merge, filter, and transform the data. These operations intend to create a high-quality data source for the  `domain`  layer. It is the responsibility of the Repository (one or more) to construct Domain models by reading from the  `Data Source`  and accepting Domain models to be written to the  `Data Source`
-   **Mapper**  - maps  `data model`  to  `domain model`  (to keep  `domain`  layer independent from the  `data`  layer).
-  **Data Sources** - This application has two  `Data Sources`  -  `remote`  (used for network access) and  `cache`  (local storage used to access device persistent memory). These data sources can be treated as an implicit sub-layer.

## Dependency Management

Gradle  [versions catalog](https://docs.gradle.org/current/userguide/platforms.html#sub:version-catalog)  is used as a centralized dependency management third-party dependency coordinates (group, artifact, version) are shared across all modules (Gradle projects and subprojects).

All of the dependencies are stored in the  [settings.gradle.kts](https://github.com/igorwojda/android-showcase/blob/main/settings.gradle.kts)  file (default location). Gradle versions catalog consists of a few major sections:

-   `[versions]`  - declare versions that can be referenced by all dependencies
-   `[libraries]`  - declare the aliases to library coordinates
-   `[bundles]`  - declare dependency bundles (groups)
-   `[plugins]`  - declare Gradle plugin dependencies


#### To be continue...
