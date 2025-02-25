package com.example.artgallery.android.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallery.android.R
import com.example.artgallery.android.components.ProfileActionCard

@Composable
fun ProfileScreen() {

    LazyColumn(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxSize().padding(all = 20.dp)
    ) {

        item {
            Spacer(modifier = Modifier.height(25.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Dennis Mugambi",
                    style = MaterialTheme.typography.displayMedium,
                    fontSize = 20.sp, color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "dennis.mutwiri.mugambi@gmaill.com",
                    style = MaterialTheme.typography.displaySmall,
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(Modifier.height(10.dp))

            Text(
                stringResource(
                    id = R.string.content
                ),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 25.dp).padding(start = 10.dp)
            )

            ProfileActionCard(
                image = R.drawable.terms_and_conditions,
                stringResource(id = R.string.leave_review)
            )

            ProfileActionCard(image = R.drawable.about, title = stringResource(id = R.string.about))

            ProfileActionCard(
                image = R.drawable.support,
                title = stringResource(id = R.string.support)
            )

            Text(
                stringResource(
                    id = R.string.settings
                ),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 25.dp).padding(start = 10.dp)
            )

            ProfileActionCard(
                image = R.drawable.skills,
                title = stringResource(id = R.string.settings)
            )

            ProfileActionCard(
                image = R.drawable.logout,
                title = stringResource(id = R.string.logout)
            )
        }
    }
}

@Composable
@Preview
fun ProfileScreenPreview() {
    ProfileScreen()
}

