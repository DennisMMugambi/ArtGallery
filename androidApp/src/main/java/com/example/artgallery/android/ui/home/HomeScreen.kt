package com.example.artgallery.android.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.artgallery.android.R
import com.example.artgallery.android.components.FeaturedItem
import com.example.artgallery.android.components.SearchBarComponent
import com.example.artgallery.android.theme.typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize().padding(all = 20.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = stringResource(id = R.string.welcome),
            style = typography.titleLarge.copy(fontSize = 30.sp),
            fontWeight = FontWeight.ExtraBold
        )


        SearchBarComponent()


        FeaturedItem(modifier = Modifier.height(200.dp).fillMaxWidth())

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = stringResource(id = R.string.exhibtions),
                style = typography.displayMedium,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = stringResource(id = R.string.see_all),
                style = typography.displayMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
        }



    }
}
