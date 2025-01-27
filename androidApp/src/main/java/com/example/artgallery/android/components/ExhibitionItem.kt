package com.example.artgallery.android.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artgallery.android.R
import com.example.artgallery.android.theme.AppTheme
import com.example.artgallery.android.theme.typography

@Composable
fun ExhibitionItem(title: String, description: String, imageUrl: String) {

    ElevatedCard(
        modifier = Modifier
            .height(300.dp)
            .padding(all = 15.dp),
        shape = RoundedCornerShape(corner = CornerSize(30.dp))
    ) {
        Row(

        ) {

            Image(
                painter = painterResource(id = R.drawable.blue_mountains),
                contentDescription = stringResource(id = R.string.exhibition_item),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(200.dp)
                    .padding(all = 15.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(30.dp))),
            )

            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .padding(vertical = 10.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    stringResource(id = R.string.sample_title),
                    style = typography.displayLarge,
                    color = Color.Black)

                Text(
                    stringResource(id = R.string.sample_description),
                    style = typography.displaySmall,
                    color = Color.Black
                )

                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.see_more),
                        color = Color.Black,
                        style = typography.displaySmall,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }
    }
}

@Preview
@Composable
fun ExhibitionItemPreview() {
    AppTheme {
        ExhibitionItem(
            title = stringResource(id = R.string.sample_title),
            description = stringResource(id = R.string.sample_description),
            imageUrl = ""
        )
    }
}