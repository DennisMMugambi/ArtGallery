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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.artgallery.android.R

@Composable
fun SignUpCard(navController: NavHostController, modifier: Modifier, onToggleSignUp: () -> Unit) {

    val agreementText = stringResource(id = R.string.sign_up_agreement)

    val termsText = "Terms and conditions"
    val privacyText = "privacy policy"


    val primaryOrange = colorResource(id = R.color.primaryOrange)


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
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(text = stringResource(id = R.string.email))
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(text = stringResource(id = R.string.password))
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth()
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = {
                            Text(text = stringResource(id = R.string.confirm_password))
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier.fillMaxWidth()
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