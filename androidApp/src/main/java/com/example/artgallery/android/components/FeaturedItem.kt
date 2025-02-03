package com.example.artgallery.android.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.artgallery.android.R

@Composable
fun FeaturedItem(modifier: Modifier) {

    Card(
        shape = RoundedCornerShape(corner = CornerSize(20.dp)),
        modifier = modifier
    ) {

        Box {
            Image(
                painter = painterResource(R.drawable.blue_mountains),
                contentDescription = stringResource(id = R.string.featured_item),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(all = 10.dp)
                    .onGloballyPositioned {
                        
                    },
                horizontalArrangement = Arrangement.Start
            )
            {
                Text(
                    stringResource(id = R.string.featured),
                    color = MaterialTheme.colorScheme.primary,
                    style = com.example.artgallery.android.theme.typography.displayMedium
                )

                Text(
                    stringResource(id = R.string.featured_sample),
                    color = Color.White,
                    style = com.example.artgallery.android.theme.typography.displayMedium
                )
            }
        }
    }
}