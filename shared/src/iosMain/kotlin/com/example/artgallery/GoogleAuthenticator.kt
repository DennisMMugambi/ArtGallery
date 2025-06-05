package com.example.artgallery

import platform.UIKit.UIApplication
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class GoogleAuthenticator {

    suspend fun login() = suspendCoroutine<String?> { continuation ->

        val rootUiView = UIApplication.sharedApplication
            .keyWindow?.rootViewController

        if(rootUiView == null){
            continuation.resume(null)
        } else {
            //GIDSignIn.sharedInstance
        }
    }
}