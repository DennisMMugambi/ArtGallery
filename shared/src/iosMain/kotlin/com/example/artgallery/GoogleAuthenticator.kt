package com.example.artgallery

import cocoapods.FirebaseAuth.FIRAuth
import cocoapods.FirebaseAuth.FIRAuthCredential
import cocoapods.FirebaseAuth.FIRAuthUIDelegateProtocol
import cocoapods.FirebaseAuth.FIRGoogleAuthProvider
import cocoapods.FirebaseAuth.FIROAuthCredential
import cocoapods.FirebaseAuth.FIROAuthProvider
import cocoapods.GoogleSignIn.GIDSignIn
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSError
import platform.UIKit.UIApplication
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class GoogleAuthenticator {

    val rootUiView = UIApplication.sharedApplication
        .keyWindow?.rootViewController

    @OptIn(ExperimentalForeignApi::class)
    suspend fun login() = suspendCoroutine<String?> { continuation ->

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
                            registerUserOnFirebase(idToken.tokenString, accessToken = result.user.accessToken.toString(), continuation)
                        } else {
                            continuation.resume(null)
                        }
                    }
                }
        }
    }

    @OptIn(ExperimentalForeignApi::class)
    fun registerUserOnFirebase(idToken: String, accessToken: String, continuation: Continuation<String?>) {

        val firebaseAuth = FIRAuth.auth()

        val googleAuthProvider = FIRGoogleAuthProvider.credentialWithIDToken(idToken, accessToken)
        firebaseAuth.signInWithCredential(googleAuthProvider) { firAuthDataResult, nsError ->
            if(nsError != null) {
                print("Something went wrong $nsError")
            } else {
                val user = firAuthDataResult?.user()
                val displayName = user?.displayName()
                continuation.resumeWith(Result.success(displayName))
            }
        }
    }

    @OptIn(ExperimentalForeignApi::class)
    fun isUserSignedIn(): Pair<Boolean, String?>  {

        return if (FIRAuth.auth().currentUser() != null) {
            Pair(true, FIRAuth.auth().currentUser()?.description)
        } else {
            Pair(false, null)
        }
    }

    @OptIn(ExperimentalForeignApi::class)
    suspend fun signInWithTwitter() = suspendCoroutine { continuation ->
        val provider = FIROAuthProvider.providerWithProviderID("twitter.com")

        val uiDelegate: FIRAuthUIDelegateProtocol? = null

        try {

            provider.getCredentialWithUIDelegate(uiDelegate) { credential: FIRAuthCredential?, error: NSError? ->
                if (error != null) {
                    println("Twitter Get Credentials Error: ${error.localizedDescription}")
                    continuation.resumeWithException(Exception("Twitter Sign-In failed during credential retrieval: ${error.localizedDescription}"))
                    return@getCredentialWithUIDelegate
                }

                if (credential != null) {
                    FIRAuth.auth()
                        .signInWithCredential(credential) { authResult, signInError: NSError? ->
                            if (signInError != null) {
                                println("Firebase Sign-In with Twitter Error: ${signInError.localizedDescription}")
                                continuation.resumeWithException(Exception("Firebase Sign-In with Twitter failed: ${signInError.localizedDescription}"))
                                return@signInWithCredential
                            }

                            val user = authResult?.user()
                            val displayName = user?.displayName()
                            println("Successfully signed in with Twitter. User: $displayName")

                            continuation.resume(displayName)
                        }
                } else {
                    println("Twitter Sign-In: Credential object is null and no error was reported.")
                    continuation.resumeWithException(Exception("Twitter Sign-In failed: No credential or error received."))
                }
            }
        } catch (e: Exception) {
            println("Twitter Sign-In Error: ${e.message}")
            continuation.resumeWithException(e)
        }
    }
}