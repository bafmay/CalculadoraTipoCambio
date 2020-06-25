package pe.retobcp

object Deps {

    object Android{
        const val appCompat = "androidx.appcompat:appcompat:${Versions.Libs.androidXAppCompatVersion}"
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Versions.Libs.navigationVersion}"
        const val navigationUI =
            "androidx.navigation:navigation-ui-ktx:${Versions.Libs.navigationVersion}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.Libs.constraintLayoutVersion}"
        const val androidKTX = "androidx.core:core-ktx:${Versions.Libs.androidXVersion}"

        const val roomRuntime =
            "android.arch.persistence.room:runtime:${Versions.Libs.roomVersion}"
        const val roomCompiler =
            "android.arch.persistence.room:compiler:${Versions.Libs.roomVersion}"
    }

    object Libs {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Libs.retrofitVersion}"
        const val retrofitScalarsConverter =
            "com.squareup.retrofit2:converter-scalars:${Versions.Libs.retrofitVersion}"
        const val retrofitGsonConverter =
            "com.squareup.retrofit2:converter-gson:${Versions.Libs.retrofitVersion}"
        const val retrofitKotlinxConverter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.Libs.retrofitKotlinxVersion}"

        const val koin = "org.koin:koin-android:${Versions.Libs.koinVersion}"
        const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.Libs.koinVersion}"
        const val okHttpInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.Libs.okHttpInterceptorVersion}"
        const val kotlinSerialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.Libs.kotlinSerializationVersion}"
    }

    object Test{
        const val mockk = "io.mockk:mockk:${Versions.Test.mockkVersion}"
        const val mockkAndroid = "io.mockk:mockk-android:${Versions.Test.mockkVersion}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Test.coroutines}"
        const val kluent = "org.amshove.kluent:kluent-android:${Versions.Test.kluentVersion}"
        const val koinTest = "org.koin:koin-test:${Versions.Test.koinTestVersion}"
    }

}