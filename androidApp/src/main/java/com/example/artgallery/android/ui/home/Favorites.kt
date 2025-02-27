package com.example.artgallery.android.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.artgallery.android.components.ExhibitionItem

@Composable
fun FavoritesScreen(navController: NavHostController) {

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 20.dp)
    ) {

        LazyColumn {
            items(10) {
                ExhibitionItem(
                    title = "",
                    description = "",
                    imageUrl = "",
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth(),
                    onclick = {
                        navController.navigate("exhibition_page")
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun FavoritesScreenPreview() {
    val navController = rememberNavController()
    FavoritesScreen(navController = navController)
}