package com.example.artgallery.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.artgallery.android.ui.login.LoginScreen
import com.example.artgallery.android.ui.main.MainView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
           LoginScreen()
        }
    }
}


