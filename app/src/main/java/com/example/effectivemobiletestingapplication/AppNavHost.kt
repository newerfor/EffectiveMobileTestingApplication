package com.example.effectivemobiletestingapplication

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core_navigation.NavRoutes
import com.example.feature_login.ui.LoginMainScreen
import com.example.feature_main.Main

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoutes.Login.routes)
    {
        composable(NavRoutes.Login.routes) {
            LoginMainScreen(
                isLoginTrue = {
                    navController.navigate(
                        NavRoutes.MainScreen.routes
                    )
                }
            )
        }
        composable(NavRoutes.MainScreen.routes){
            Main()
        }
    }
}
