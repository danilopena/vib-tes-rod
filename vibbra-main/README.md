# Vibbra - challenge

Login | Dashboard
--- | ---
![](http://git.vibbra.com.br/rodrigo-1632095062/vibbra/-/raw/main/images/login.png) | ![](http://git.vibbra.com.br/rodrigo-1632095062/vibbra/-/raw/main/images/dashboard.png)

## This project requires:

- Java 11 to run
- Android Studio Artic Fox

As the API is mocked you can login with any values since there is no definition of login or password requirements

## Architecture

* Kotlin
* MVVM (LiveData)
* Clean Architecture
* Jetpack navigation
* Hilt

## buildSrc

Is the module where you can find all the dependencies that the project owns, this modules aims to provides
a easy way to reuse dependencies through modules.

## Structure

The network layer is not implemented as the web service is mocked, there is the abstraction of remote data source
to facilitate the implementation once the API is ready for testing.ViewState

The app is using the concept of single activity, and all the screens are build using fragments, and with
jetpack navigation we can navigate through them.

## Dependency Injection

This project is using Hilt to provides injected dependencies, there is only two modules
- DataModule
    Where the binds of the data layer are
        Data sources
- DomainModule
    Where the binds of the domain layer are
        UseCases and Repository

## Mocks

You can found the mock generator in the data layer it is a simple generator.

## Repository layer

It is a proxy between useCases and DataSources, the main responsibility it to know where to fetch the data
and control cache policy rules.

### Features
* repository -> View -> VM -> UseCase -> Repository -> DataSources

## View Models

The ViewModel has two complementary classes Action and ViewState
- Action is when the view sends a action for the viewModel for example user taps in the login button
- ViewStates controls how the view should behave when the viewModel finish his jobs
    State: For example loading
    Action: Show an error when the request fail

All the screen are using base styles from material to make easy the theming change (dark and light)

## Improvements

- Since the API is mocked the network interceptor for sending authentication token was not made
- Implement the mapper layer to abstract response models from the UI and parse it for the models
- The SSO authentication is working with empty values, the idea is to have third party connection and get the real values
- The authentication is working with any values, there is no definition of what should happen on invalid credentials or request error
- Persist user session, right know the app is not persisting the user session in the shared preferences or ...
- Add error feedbacks



