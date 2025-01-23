package com.example.artgallery

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform