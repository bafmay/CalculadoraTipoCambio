package com.retobcp.features.splash

sealed class SplashViewState {
    object Success: SplashViewState()
    class Failure(val message: String) : SplashViewState()
}