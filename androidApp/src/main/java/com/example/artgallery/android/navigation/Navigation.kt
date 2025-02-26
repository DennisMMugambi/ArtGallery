package com.example.artgallery.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.artgallery.android.ui.exhibition.ExhibitionFeed
import com.example.artgallery.android.ui.exhibition.ExhibitionPage
import com.example.artgallery.android.ui.gallery.GalleryFeed
import com.example.artgallery.android.ui.gallery.GalleryItemPage
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
        composable("exhibition_page") {
            ExhibitionPage(navController)
        }
        composable("gallery_page") {
            GalleryItemPage(navController)
        }
        composable("gallery_feed"){
            GalleryFeed(navController)
        }
        composable("exhibition_feed"){
            ExhibitionFeed(navController)
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