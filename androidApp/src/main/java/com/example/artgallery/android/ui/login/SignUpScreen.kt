package com.example.artgallery.android.ui.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.artgallery.android.R
import com.example.artgallery.android.components.LoginCard
import com.example.artgallery.android.components.SignUpCard


@Composable
fun SignUpScreen(navController: NavHostController, isSignUp: Boolean) {

    var signUp by remember { mutableStateOf(isSignUp) }
    val density = LocalDensity.current

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.african_portrait),
            contentDescription = stringResource(id = R.string.login_page_screen),
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize()
        )

        AnimatedVisibility(
            visible = signUp,
            enter = slideInVertically {
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                expandFrom = Alignment.Bottom
            ) + fadeIn(
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut(),
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            SignUpCard(
                navController = navController,
                onToggleSignUp = { signUp = !signUp },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
            )
        }

        AnimatedVisibility(
            visible = !signUp,
            enter = slideInVertically {
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                expandFrom = Alignment.Bottom
            ) + fadeIn(
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut(),
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            LoginCard(
                navController = navController,
                onToggleSignUp = { signUp = !signUp },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)

            )
        }


    }

}

@Composable
@Preview
fun SignUpScreen_Preview() {

    val navController = rememberNavController()

    SignUpScreen(navController = navController, isSignUp = false)
}