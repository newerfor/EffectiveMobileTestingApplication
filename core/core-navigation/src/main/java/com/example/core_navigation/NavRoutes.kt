package com.example.core_navigation

sealed class NavRoutes(val routes: String) {
    object Login : NavRoutes("login")
    object MainScreen : NavRoutes("main")
    object Favorite : NavRoutes("favorite")
    object Profile : NavRoutes("profile")
}