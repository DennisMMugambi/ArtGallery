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
import com.example.artgallery.android.ui.home.HomeScreen
import com.example.artgallery.android.ui.login.LandingScreen
import com.example.artgallery.android.ui.login.LoginScreen
import com.example.artgallery.android.ui.login.SignUpScreen
import com.example.artgallery.android.ui.home.MainView
import com.example.artgallery.model.GoogleAuthenticator

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val googleAuthenticator = GoogleAuthenticator(context = null, credentialManager = null)

    val isSignedIn = googleAuthenticator.isUserSignedIn()

    val startDestination = if (isSignedIn.first) "home" else "login"

    NavHost(navController = navController, startDestination = startDestination) {
        composable("landing") {
            LandingScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable(
            route = "home/(username)",
            arguments = listOf(navArgument("userName") { type = NavType.StringType})
        ) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: isSignedIn.second
            if (userName != null) {
                HomeScreen(navController, userName)
            }
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