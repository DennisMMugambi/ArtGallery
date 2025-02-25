package com.example.artgallery.android.ui.exhibition

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import com.example.artgallery.android.components.TopBar
import com.example.artgallery.android.theme.typography


@Composable
fun ExhibitionPage(navController: NavHostController) {

    var isFavorite by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopBar(navController)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 20.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.blue_mountains),
                        contentDescription = stringResource(id = R.string.exhibition_item),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(20.dp))
                    )

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
                    )
                    {
                        Text(
                            stringResource(id = R.string.sample_exhibition),
                            style = typography.displayMedium,
                            color = Color.Black
                        )

                        Row {
                            Icon(
                                imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                                contentDescription = stringResource(id = R.string.favorite),
                                tint = if (isFavorite) Color.Red else Color.Black,
                                modifier = Modifier
                                    .clickable { isFavorite = !isFavorite }
                                    .padding(end = 16.dp)
                            )

                            Icon(
                                imageVector = Icons.Filled.Share,
                                contentDescription = stringResource(id = R.string.share),
                                tint = Color.Black,
                                modifier = Modifier.clickable {

                                }
                            )
                        }
                    }

                    Text(
                        stringResource(id = R.string.sample_exhibition_description),
                        style = typography.displaySmall,
                        color = Color.Black
                    )
                }

//                Button(
//                    onClick = {
//                        // Handle button click
//                    },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(50.dp)
//                ) {
//                    Text(
//                        text = stringResource(id = R.string.start_tour),
//                        color = Color.Black
//                    )
//                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ExhibitionPage_Preview() {
    val navController = rememberNavController()
    ExhibitionPage(navController)
}