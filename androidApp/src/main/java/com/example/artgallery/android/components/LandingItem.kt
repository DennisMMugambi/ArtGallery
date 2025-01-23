package com.example.artgallery.android.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.artgallery.android.R

@Composable
fun LandingItem(image: Int, title: String, description: String) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.padding(top = 50.dp)
    ) {

        Image(
            painter = painterResource(id = image),
            contentDescription = stringResource(id = R.string.landing_image_description),
            modifier = Modifier.size(350.dp, 350.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            title, style = MaterialTheme.typography.displayLarge,
            color = Color.Black
        )

        Text(
            description,
            style = MaterialTheme.typography.displaySmall,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 20.dp).padding(top = 10.dp),
            textAlign = TextAlign.Center
        )

    }
}