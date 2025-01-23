package com.example.artgallery.android.ui.login


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artgallery.android.R
import com.example.artgallery.android.components.LandingItem
import com.example.artgallery.android.theme.AppTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoginScreen() {

    val pageTitles = listOf(
        stringResource(id = R.string.title_1),
        stringResource(id = R.string.title_2),
        stringResource(id = R.string.title_3)
    )

    val pageDescriptions = listOf(
        stringResource(id = R.string.description_1),
        stringResource(id = R.string.description_2),
        stringResource(id = R.string.description_3)
        )

    val images = listOf(
        R.drawable.landing1,
        R.drawable.landing2,
        R.drawable.landing3
    )

    val coroutineScope = rememberCoroutineScope()

    val pagerState = rememberPagerState(pageCount = {pageTitles.size})

    AppTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.SpaceAround
        ) {


                HorizontalPager(
                    state = pagerState
                ) { page ->
                    LandingItem(
                        image = images[page],
                        title = pageTitles[page],
                        description = pageDescriptions[page]
                    )
                }


                Spacer(modifier = Modifier.weight(1f))

                Row( modifier = Modifier.wrapContentHeight()
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.Center) {

                    repeat(pagerState.pageCount) { iteration ->

                        val color = if (pagerState.currentPage == iteration) MaterialTheme.colorScheme.primary else Color.LightGray

                        if (pagerState.currentPage == iteration) {

                            Box(
                                modifier = Modifier
                                    .padding(2.dp)
                                    .clip(RoundedCornerShape(50.dp))
                                    .background(color)
                                    .height(8.dp)
                                    .width(50.dp)
                            )
                        } else {

                            Box(
                                modifier = Modifier
                                    .padding(2.dp)
                                    .clip(CircleShape)
                                    .background(color)
                                    .height(8.dp)
                                    .width(20.dp)
                            )
                        }
                    }
                }

            Spacer(modifier = Modifier.weight(1f))

            if(pagerState.currentPage != pageTitles.size - 1) {

                Row(
                    modifier = Modifier.fillMaxWidth().padding(all = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    OutlinedButton(
                        onClick = {
                            coroutineScope.launch {
                                pagerState.scrollToPage(pageTitles.size - 1)
                            }
                        },
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
                    ) {
                        Text(text = stringResource(id = R.string.skip), color = Color.Black)
                    }

                    Button(
                        onClick = {
                            coroutineScope.launch {
                                val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
                                pagerState.animateScrollToPage(nextPage)
                            }
                        }
                    ) {
                        Text(text = stringResource(id = R.string.next))
                    }
                }
            } else {

                Column(
                    modifier = Modifier.fillMaxWidth().padding(all = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Button(
                        onClick = {
                            coroutineScope.launch {
                                val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
                                pagerState.animateScrollToPage(nextPage)
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = stringResource(id = R.string.get_started), color = Color.Black)
                    }

                    Row {
                        Text(
                            text = stringResource(id = R.string.already_have_an_account),
                            style = MaterialTheme.typography.displaySmall,
                            color = Color.Black
                        )
                        Text(
                            text = stringResource(id = R.string.login),
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.displaySmall.copy(textDecoration = TextDecoration.Underline)
                        )
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    AppTheme {
        LoginScreen()
    }
}