package com.example.artgallery.android.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artgallery.android.R

@Composable
fun SettingsItem() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        MaterialTheme.colorScheme.primary

        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = stringResource(id = R.string.notification_icon),
                    tint = Color.White,
                    modifier = Modifier.padding(start = 10.dp)
                )

                Text(
                    stringResource(id = R.string.notifications),
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                Spacer(modifier = Modifier.weight(2f))

                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = stringResource(id = R.string.arrow_right_icon),
                    tint = Color.White,
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun SettingsItemPreview() {
    SettingsItem()
}