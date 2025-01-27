package com.example.artgallery.android.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.artgallery.android.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarComponent() {

    SearchBar(
        query = "",
        onQueryChange = {},
        onSearch = {},
        active = true,
        onActiveChange = {},
        placeholder = {
            Text(text = stringResource(id = R.string.search))
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                tint = Color.Gray,
                contentDescription = "search icon"
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Edit,
                tint = Color.Gray,
                contentDescription = "search icon"
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
    ) {


    }
}