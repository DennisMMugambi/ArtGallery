package com.example.artgallery

import cocoapods.FirebaseAuth.FIRAuth
import cocoapods.FirebaseAuth.FIROAuthProvider
import cocoapods.GoogleSignIn.GIDSignIn
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIApplication
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class GoogleAuthenticator {

    @OptIn(ExperimentalForeignApi::class)
    suspend fun login() = suspendCoroutine<String?> { continuation ->

        val rootUiView = UIApplication.sharedApplication
            .keyWindow?.rootViewController

        if(rootUiView == null){
            continuation.resume(null)
        } else {
            GIDSignIn.sharedInstance
                .signInWithPresentingViewController(rootUiView) { result, error ->
                    if(error!=null) {
                        println("Something went wrong")
                    } else {
                        val idToken = result?.user?.idToken
                        val profile = result?.user?.profile

                        if(idToken != null) {
                            registerUserOnFirebase(idToken.tokenString, continuation)
                        } else {
                            continuation.resume(null)
                        }
                    }
                }
        }
    }

    @OptIn(ExperimentalForeignApi::class)
    fun registerUserOnFirebase(idToken: String, continuation: Continuation<String?>) {

        val firebaseAuth = FIRAuth.auth()
        val credential = FIROAuthProvider.credentialWithProviderID("com.google", idToken)
        firebaseAuth.signInWithCredential(credential) { firAuthDataResult, nsError ->
            if(nsError != null) {
                print("Something went wrong $nsError")
            } else {
                val user = firAuthDataResult?.user()
                val displayName = user?.displayName()
                continuation.resumeWith(Result.success(displayName))
            }
        }
    }
}