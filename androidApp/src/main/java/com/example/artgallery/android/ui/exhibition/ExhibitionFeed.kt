package com.example.artgallery.android.ui.exhibition

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.artgallery.android.R
import com.example.artgallery.android.components.ExhibitionItem
import com.example.artgallery.android.components.SearchBarComponent
import com.example.artgallery.android.components.TopBar

@Composable
fun ExhibitionFeed(navController: NavHostController) {

    Scaffold(
        topBar = {
            TopBar(navController, stringResource(id = R.string.exhibitions))
        },
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(Color.White)
        ) {

            SearchBarComponent()

            LazyColumn(
                modifier = Modifier
                    .padding(top = 20.dp)
            ) {
                items(100) {
                    ExhibitionItem(
                        title = "",
                        description = "",
                        imageUrl = "",
                        modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth()
                            .padding(start = 10.dp),
                        onclick = {
                            navController.navigate("exhibition_page")
                        }
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun ExhibitionFeedPreview() {
    val navController = rememberNavController()
    ExhibitionFeed(navController)
}