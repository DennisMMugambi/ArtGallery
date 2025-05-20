package com.example.artgallery.android.ui.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.credentials.CredentialManager
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.artgallery.android.R
import com.example.artgallery.android.theme.AppTheme
import com.example.artgallery.android.theme.typography
import com.example.artgallery.model.GoogleAuthenticator
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavHostController) {

    val context = LocalContext.current

    val scope = rememberCoroutineScope()

    val googleAuthenticator = remember { GoogleAuthenticator(context = context, credentialManager = CredentialManager.create(context)) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.mountain_bg),
            contentDescription = stringResource(id = R.string.login_page_screen),
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(all = 20.dp)
        ) {

            Spacer(modifier = Modifier.weight(1.5f))

            Text(stringResource(id = R.string.get_started), color = Color.White, style = typography.displayMedium)
            Text(stringResource(id = R.string.login_description), color = Color.White, style = typography.displaySmall)

            Spacer(modifier = Modifier.weight(0.3f))

            OutlinedButton(
                onClick = {
                    navController.navigate("register/true")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(vertical = 5.dp),
                border = BorderStroke(1.dp, Color.White),
                shape = RoundedCornerShape(5.dp)
            ) {
                Row {
                    Image(
                        imageVector = Icons.Filled.Email,
                        contentDescription = stringResource(id = R.string.email_icon),
                        colorFilter = ColorFilter.tint(color = Color.White),
                        modifier = Modifier.size(25.dp)
                    )

                    Spacer(modifier = Modifier.width(15.dp))

                    Text(text = stringResource(id = R.string.sign_up_email), color = Color.White, style = typography.displaySmall)
                }
            }

            Button(
                onClick = {
                    scope.launch {
                        val response = googleAuthenticator.login()
                        if(!response.contains("Error")) {
                            navController.navigate("home")
                        } else {
                            //Display error to the user
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(vertical = 5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(5.dp)
            ) {
                Row{
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = stringResource(id = R.string.email_icon),
                        modifier = Modifier.size(25.dp)
                    )

                    Spacer(modifier = Modifier.width(15.dp))

                    Text(text = stringResource(id = R.string.sign_up_google), color = Color.Black, style = typography.displaySmall)
                }
            }

            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(vertical = 5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                shape = RoundedCornerShape(5.dp)
            ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = stringResource(id = R.string.email_icon),
                        modifier = Modifier.size(25.dp),
                    )

                    Spacer(modifier = Modifier.width(15.dp))

                    Text(text = stringResource(id = R.string.sign_up_facebook), color = Color.White, style = typography.displaySmall)
                }
            }

            Row(
                horizontalArrangement = Arrangement.Absolute.Center,
                modifier = Modifier.fillMaxWidth()
            )
            {
                Text(
                    text = stringResource(id = R.string.already_have_an_account),
                    style = typography.displaySmall,
                    color = Color.White
                )
                Text(
                    text = stringResource(id = R.string.login),
                    color = MaterialTheme.colorScheme.primary,
                    style = typography.displaySmall.copy(textDecoration = TextDecoration.Underline),
                    modifier = Modifier.clickable {
                        navController.navigate("register/false")
                    }
                )
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {

    val navController = rememberNavController()

    AppTheme {
        LoginScreen(navController)
    }
}