package com.example.artgallery.android.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.example.artgallery.android.theme.AppTheme
import com.example.artgallery.android.theme.EmptyComposable
import com.example.artgallery.android.theme.topBarFun

sealed class Screen(val title: String) {
    object Landing : Screen("")
    object Login : Screen("Login")
    object Register : Screen("Register")
    object Home : Screen("Home")
    object Profile : Screen("Profile")
    object Favorite : Screen("Favorite")
    object Shop : Screen("Shop")
    object Settings : Screen("Settings")
}

data class BottomNavigationItem(
    val route: String,
    val icon: ImageVector,
    val iconContentDescription: String
)

val bottomNavigationItems = listOf(
    BottomNavigationItem(
        Screen.Home.title,
        Icons.Filled.Home,
        "Home"
    ),
    BottomNavigationItem(
        Screen.Favorite.title,
        Icons.Filled.FavoriteBorder,
        "Favorite"
    ),
    BottomNavigationItem(
        Screen.Shop.title,
        Icons.Filled.ShoppingCart,
        "Shop"
    ),
    BottomNavigationItem(
        Screen.Profile.title,
        Icons.Filled.Person,
        "Profile"
    )
)

@Composable
fun MainView(actionBarFun: topBarFun = { EmptyComposable() }, navController: NavHostController) {

    val selectedIndex = remember { mutableStateOf(0) }

    AppTheme {
        Scaffold (
            topBar = {
                actionBarFun(selectedIndex.value)
            },
            bottomBar = {

                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.secondary
                ) {
                    bottomNavigationItems.forEachIndexed { index, item ->
                        NavigationBarItem(
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                unselectedIconColor = Color.Black
                            ),
                            label = {
                                Text(
                                    item.route,
                                    style = MaterialTheme.typography.labelMedium
                                )
                            },
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.iconContentDescription
                                )
                            },
                            selected = selectedIndex.value == index,
                            onClick = {
                                selectedIndex.value = index
                            }
                        )
                    }
                }
            }
        ) { innerPadding ->

            Column(
                modifier = Modifier.padding(innerPadding)
                    .background(Color.White)
            ) {

                when (selectedIndex.value) {
                    0 -> HomeScreen()
                    1 -> FavoritesScreen()
                    2 -> ShopScreen()
                    3 -> ProfileScreen()
                }
            }

        }
    }
}