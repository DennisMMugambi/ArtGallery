package com.example.artgallery.android.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallery.android.R

@Composable
fun ProfileActionCard(image : Int, title: String) {

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.fillMaxWidth()
            .padding(all = 5.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 25.dp)
                .padding(vertical = 20.dp)
        ) {

            Image(
                painter = painterResource(image),
                contentDescription = "Action Settings Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(20.dp)
            )


            Text(
                title,
                style = com.example.artgallery.android.theme.typography.displayMedium,
                fontSize = 18.sp,
                color = Color.Black
            )


            Image(
                painter = painterResource(R.drawable.next),
                contentDescription = "More image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}