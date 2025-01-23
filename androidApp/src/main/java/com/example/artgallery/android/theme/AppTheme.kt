package com.example.artgallery.android.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = Color(0xFFF77F00),
            secondary = Color(0xFFF1ECCF),
            tertiary = Color(0xFF040F0F),
            surface = Color(0xFFFEFDF5),
            background = Color(0xFFF8F5E7)
        )
    } else {
        lightColorScheme(
            primary = Color(0xFFF77F00),
            secondary = Color(0xFFF1ECCF),
            tertiary = Color(0xFF040F0F),
            surface = Color(0xFFFEFDF5),
            background = Color(0xFFF8F5E7)
        )
    }
    val typography = typography
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
