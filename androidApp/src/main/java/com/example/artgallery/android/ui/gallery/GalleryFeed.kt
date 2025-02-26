package com.example.artgallery.android.ui.gallery

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.artgallery.android.R
import com.example.artgallery.android.components.SearchBarComponent
import com.example.artgallery.android.components.TopBar

@Composable
fun GalleryFeed(navController: NavHostController) {

    Scaffold(
        topBar = {
            TopBar(navController, stringResource(id = R.string.galleries))
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

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(start = 10.dp).padding(top = 20.dp)
            ) {
                items(100) {
                    Image(
                        painter = painterResource(R.drawable.african_portrait),
                        contentDescription = stringResource(id = R.string.gallery_item),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(300.dp)
                            .width(150.dp)
                            .padding(vertical = 5.dp)
                            .padding(end = 10.dp)
                            .clip(RoundedCornerShape(corner = CornerSize(15.dp)))
                            .clickable {
                                navController.navigate("gallery_page")
                            }
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun GalleryFeedPreview() {

    val navController = rememberNavController()

    GalleryFeed(navController)
}