package com.example.effectivemobiletestingapplication

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core_navigation.NavRoutes
import com.example.feature_favorit_course.ui.FavoriteCourseMain
import com.example.feature_login.ui.LoginMainScreen
import com.example.feature_main.ui.Main
import com.example.feature_single_course.CourseInfoMain

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoutes.CourseInfo.routes)
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
            Main(navController)
        }
        composable (NavRoutes.Favorite.routes){
            FavoriteCourseMain(navController)
        }
        composable(NavRoutes.CourseInfo.routes){
            CourseInfoMain(navController,100)
        }
    }
}
