package com.example.artgallery.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.artgallery.android.ui.login.LandingScreen
import com.example.artgallery.android.ui.login.LoginScreen

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
    }
}