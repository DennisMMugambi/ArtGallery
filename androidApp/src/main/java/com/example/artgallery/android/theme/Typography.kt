package com.example.artgallery.android.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.artgallery.android.R

val typography = Typography(
    displayLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.comicneue_bold)),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.comicneue_regular)),
        fontSize = 20.sp,
        color = Color.White
    ),
    displaySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.comicneue_light)),
        fontSize = 12.sp,
        color = Color.White
    )
)