package com.example.artgallery.android.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.credentials.CredentialManager
import androidx.navigation.NavHostController
import com.example.artgallery.android.R
import com.example.artgallery.model.GoogleAuthenticator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpCard(navController: NavHostController, modifier: Modifier, onToggleSignUp: () -> Unit) {

    val agreementText = stringResource(id = R.string.sign_up_agreement)

    val termsText = "Terms and conditions"
    val privacyText = "privacy policy"

    val context = LocalContext.current

    val googleAuthenticator = remember {
        GoogleAuthenticator(
            context = context,
            credentialManager = null
        )
    }


    val primaryOrange = colorResource(id = R.color.primaryOrange)

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val annotatedText = buildAnnotatedString {
        append(agreementText)


        val termsStart = agreementText.indexOf(termsText)
        if (termsStart >= 0) {
            addStyle(
                style = SpanStyle(color = primaryOrange, textDecoration = TextDecoration.Underline),
                start = termsStart,
                end = termsStart + termsText.length
            )
        }


        val privacyStart = agreementText.indexOf(privacyText)
        if (privacyStart >= 0) {
            addStyle(
                style = SpanStyle(color = primaryOrange, textDecoration = TextDecoration.Underline),
                start = privacyStart,
                end = privacyStart + privacyText.length
            )
        }
    }

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 5.dp)
                .padding(bottom = 20.dp)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Column {
                Text(
                    stringResource(id = R.string.sign_up_email),
                    color = Color.Black,
                    style = typography.displayLarge.copy(fontSize = 28.sp),
                )

                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                )
                {
                    Text(
                        text = stringResource(id = R.string.already_have_an_account),
                        style = typography.displaySmall,
                        color = Color.Black
                    )
                    Text(
                        text = stringResource(id = R.string.login),
                        color = MaterialTheme.colorScheme.primary,
                        style = typography.displaySmall.copy(textDecoration = TextDecoration.Underline),
                        modifier = Modifier.clickable {
                            onToggleSignUp()
                        }
                    )
                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    label = {
                        Text(text = stringResource(id = R.string.email))
                    },
                    textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    )
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    label = {
                        Text(text = stringResource(id = R.string.password))
                    },
                    textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    )
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = {
                            confirmPassword = it
                        },
                        label = {
                            Text(text = stringResource(id = R.string.confirm_password))
                        },
                        textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedLabelColor = Color.Black,
                            unfocusedLabelColor = Color.Black,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        )
                    )

                    Row(
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.fillMaxWidth()
                    )

                    {
                        Text(
                            text = annotatedText,
                            style = typography.bodySmall,
                            color = Color.Black,
                            modifier = Modifier.padding(horizontal = 50.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Button(
                onClick = {
                    navController.navigate("home")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.sign_up),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }

        }

    }
}