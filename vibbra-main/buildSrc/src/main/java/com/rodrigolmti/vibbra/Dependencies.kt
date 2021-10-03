object ApplicationId {
    const val id = "br.com.rodrigolmti.password_keeper"
}

object Versions {
    const val kotlin = "1.5.30"
    const val tools = "7.0.2"
    const val gradle = "4.0.0"
    const val buildTools = "30.0.2"
    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = 30
}

object Releases {
    const val versionCode = 2
    const val versionName = "1.0.1"
}

object ImageLoader {
    object Versions {
        const val coil = "1.3.2"
    }

    const val coil = "io.coil-kt:coil:${Versions.coil}"
}

object Kotlin {
    object Versions {
        const val ktx = "1.3.2"
        const val junitX = "1.1.2"
        const val junit = "4.13.2"
    }

    const val core = "androidx.core:core-ktx:${Versions.ktx}"
}

object Lifecycle {
    object Versions {
        const val lifecycle = "2.3.1"
    }

    const val common = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
}

object Hilt {
    object Versions {
        const val hilt = "2.38.1"
    }

    const val core = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
}

object Coroutines {
    object Versions {
        const val coroutines = "1.5.1"
    }

    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
}

object Moshi {
    object Versions {
        const val moshi = "1.10.0"
    }

    const val coreKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
}

object Retrofit {
    object Versions {
        const val retrofit = "2.9.0"
        const val interceptor = "4.8.0"
    }

    const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
}

object Navigation {
    object Versions {
        const val navigationVersion = "2.3.5"
    }

    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    const val navigationArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}"
}

object AndroidX {
    object Versions {
        const val ktx = "1.6.0"
        const val appcompat = "1.3.1"
        const val support = "1.4.0"
        const val fragment = "1.3.6"
        const val constraintLayout = "2.0.4"
        const val servicesLocation = "18.0.0"
    }

    const val servicesLocation =
        "com.google.android.gms:play-services-location:${Versions.servicesLocation}"

    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val design = "com.google.android.material:material:${Versions.support}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}