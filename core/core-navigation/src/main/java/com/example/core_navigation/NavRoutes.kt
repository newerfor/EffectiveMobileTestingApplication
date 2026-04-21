package com.example.core_navigation

sealed class NavRoutes(val routes: String) {
    object Login : NavRoutes("login")
    object MainScreen : NavRoutes("main")
}