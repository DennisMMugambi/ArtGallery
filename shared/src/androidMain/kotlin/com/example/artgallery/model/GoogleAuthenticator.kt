package com.example.artgallery.model

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.Log
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialException
import androidx.credentials.exceptions.NoCredentialException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.tasks.await
import com.example.artgallery.BuildConfig
import com.google.firebase.auth.OAuthProvider

class GoogleAuthenticator(
    private val context: Context?,
    private val credentialManager: CredentialManager?
)
{

    val auth = FirebaseAuth.getInstance()

    suspend fun login() : String {

            try {
                val googleIdOption = GetGoogleIdOption.Builder()
                    .setServerClientId(BuildConfig.GOOGLE_SERVER_CLIENT_ID)
                    .setAutoSelectEnabled(false)
                    .setFilterByAuthorizedAccounts(false)
                    .build()

                val request = GetCredentialRequest.Builder()
                    .addCredentialOption(googleIdOption)
                    .build()

                val result = context?.let { credentialManager?.getCredential(it, request) }

                val credential = result?.credential

                if (credential is CustomCredential && credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {

                    val googleIdTokenCredential =
                        GoogleIdTokenCredential.createFrom(credential.data)
                    val idToken = googleIdTokenCredential.idToken

                    val authCredential = GoogleAuthProvider.getCredential(idToken, null)
                    val fireBase = FirebaseAuth.getInstance()
                    val user = fireBase.signInWithCredential(authCredential).await().user

                    return user?.displayName.toString()
                }

                return "Error: Something went wrong"
            } catch (e: NoCredentialException) {
                return "Error: No email found on this devices"
            } catch (e: GetCredentialException) {
                return "Error: Get Credential Exception"
            } catch (e: Exception) {
                return "Error: ${e.message.toString()}"
            }
    }

    fun isUserSignedIn(): Pair<Boolean, String?>  {

        return if (auth.currentUser != null) {
            Pair(true, auth.currentUser?.displayName)
        } else {
            Pair(false, null)
        }
    }

    fun logout() {
        auth.signOut()
    }

    fun signInWithTwitter()  {

        val provider = OAuthProvider.newBuilder("twitter.com")

        val pendingResultTask = auth.pendingAuthResult

        if(pendingResultTask != null) {

            pendingResultTask.addOnSuccessListener {
                //User is signed in
                Log.d("TAG", "signInWithTwitter: ${it.credential}")
            }
                .addOnFailureListener {
                    //Handle failure by displaying appropriate error message
                }
        } else {
        // there is no pending result so you need to start the sign in flow
            context?.findActivity()?.let { auth.startActivityForSignInWithProvider(it, provider.build())
                .addOnSuccessListener {
                    // User is signed in
                    Log.d("TAG", "signInWithTwitter: ${it.credential}")
                }
                .addOnSuccessListener {
                    // Handle failure and display error message to the user
                }
            }
        }

    }

    fun Context.findActivity(): Activity? = when (this) {
        is Activity -> this
        is ContextWrapper -> baseContext.findActivity()
        else -> null
    }

}