package com.example.artgallery.android.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.artgallery.android.R
import com.example.artgallery.android.components.ExhibitionItem
import com.example.artgallery.android.components.FeaturedItem
import com.example.artgallery.android.components.SearchBarComponent
import com.example.artgallery.android.theme.typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier.padding(all = 20.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.Start
    ) {
        item {
            Text(
                text = stringResource(id = R.string.welcome),
                style = typography.titleLarge.copy(fontSize = 30.sp),
                fontWeight = FontWeight.ExtraBold
            )
        }

        item {
            SearchBarComponent()
        }

        item {
            FeaturedItem(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.exhibtions),
                    style = typography.displaySmall,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = stringResource(id = R.string.see_all),
                    style = typography.displaySmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        item {
            LazyRow {
                items(10) {
                    ExhibitionItem(
                        title = "",
                        description = "",
                        imageUrl = "",
                        modifier = Modifier
                            .height(200.dp)
                            .width(310.dp)
                    )
                }
            }
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.galleries),
                    style = typography.displaySmall,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = stringResource(id = R.string.see_all),
                    style = typography.displaySmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        item {
            LazyRow {
                items(10) {
                    Image(
                        painter = painterResource(R.drawable.african_portrait),
                        contentDescription = stringResource(id = R.string.gallery_item),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(200.dp)
                            .width(150.dp)
                            .padding(vertical = 5.dp)
                            .padding(end = 10.dp)
                            .clip(RoundedCornerShape(corner = CornerSize(15.dp))),
                    )
                }
            }
        }
    }
}