package com.example.artgallery.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.artgallery.android.ui.login.LandingScreen
import com.example.artgallery.android.ui.login.LoginScreen
import com.example.artgallery.android.ui.login.SignUpScreen
import com.example.artgallery.android.ui.home.MainView

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "landing") {
        composable("landing") {
            LandingScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("home") {
            MainView({}, navController)
        }
        composable(
            route = "register/{isSignUp}",
            arguments = listOf(navArgument("isSignUp") { type = NavType.BoolType })
        ) { backStackEntry ->
            val isSignUp = backStackEntry.arguments?.getBoolean("isSignUp") ?: false
            SignUpScreen(navController, isSignUp)
        }
    }
}