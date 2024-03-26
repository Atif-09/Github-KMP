package com.atif.wear.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Card
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import androidx.wear.compose.material.rememberScalingLazyListState
import androidx.wear.compose.material.scrollAway
import api.ApiClass
import coil.compose.AsyncImage
import com.atif.wear.presentation.singleton.LoginObject
import kotlinx.coroutines.launch
import model.SearchUserDataClass

@Composable
fun WearDetailsScreenUI(navController: NavHostController) {
    var user by remember { mutableStateOf<SearchUserDataClass?>(null) }
    val userData = LoginObject.loginId ?: "seabdulbasit"
    val scope = rememberCoroutineScope()
    val listState = rememberScalingLazyListState()

    LaunchedEffect(Unit) {
        scope.launch {
            user = ApiClass().getUser(userData)
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF001f25)),
        contentAlignment = Alignment.Center
    ) {
        Scaffold(
            timeText = { TimeText(modifier = Modifier.scrollAway(listState)) },
            vignette = { Vignette(vignettePosition = VignettePosition.TopAndBottom) },
            positionIndicator = {
                PositionIndicator(
                    scalingLazyListState = listState
                )
            }
        ) {

    user?.let {



                ScalingLazyColumn(
                    content = {
                        item {
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(100),
                                modifier = Modifier.size(ButtonDefaults.LargeButtonSize),

                                ) {
                                AsyncImage(
                                    it.avatar_url,
                                    null,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Fit
                                )
                            }
                        }

                        item {
                            Card(onClick = {}) {
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalArrangement = Arrangement.spacedBy(12.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        "Name:",
                                        modifier = Modifier,
                                        letterSpacing = 0.5.sp,
                                        color = Color(0xFF8ecede)
                                    )

                                    Text(
                                        it.name,
                                        fontFamily = FontFamily.Default,
                                        fontWeight = FontWeight.Normal,
                                        letterSpacing = 0.5.sp,
                                        color = Color(0xFF8ecede)
                                    )
                                    Text(
                                        "Repos:",
                                        modifier = Modifier,
                                        letterSpacing = 0.5.sp,
                                        color = Color(0xFF8ecede)
                                    )
                                    Text(
                                        it.public_repos.toString(),
                                        fontFamily = FontFamily.Default,
                                        fontWeight = FontWeight.Normal,
                                        letterSpacing = 0.5.sp,
                                        color = Color(0xFF8ecede)
                                    )

                                    Text(
                                        "Gists:",
                                        modifier = Modifier,
                                        letterSpacing = 0.5.sp,
                                        color = Color(0xFF8ecede)
                                    )

                                    Text(
                                        it.public_gists.toString(),
                                        fontFamily = FontFamily.Default,
                                        fontWeight = FontWeight.Normal,
                                        letterSpacing = 0.5.sp,
                                        color = Color(0xFF8ecede)
                                    )

                                    Text(
                                        "Followers:",
                                        modifier = Modifier,
                                        letterSpacing = 0.5.sp,
                                        color = Color(0xFF8ecede)
                                    )

                                    Text(
                                        it.followers.toString(),
                                        fontFamily = FontFamily.Default,
                                        fontWeight = FontWeight.Normal,
                                        letterSpacing = 0.5.sp,
                                        color = Color(0xFF8ecede)
                                    )

                                    Text(
                                        "Following:",
                                        modifier = Modifier,
                                        letterSpacing = 0.5.sp,
                                        color = Color(0xFF8ecede)
                                    )
                                    Text(
                                        it.following.toString(),
                                        fontFamily = FontFamily.Default,
                                        fontWeight = FontWeight.Normal,
                                        letterSpacing = 0.5.sp,
                                        color = Color(0xFF8ecede)
                                    )

                                    Text(
                                        "Created At:",
                                        modifier = Modifier,
                                        letterSpacing = 0.5.sp,
                                        color = Color(0xFF8ecede)
                                    )

                                    Text(
                                        it.created_at.substring(0, 10),
                                        fontFamily = FontFamily.Default,
                                        fontWeight = FontWeight.Normal,
                                        letterSpacing = 0.5.sp,
                                        color = Color(0xFF8ecede)
                                    )

                                    Text(
                                        "Updated At:",
                                        modifier = Modifier,
                                        letterSpacing = 0.5.sp,
                                        color = Color(0xFF8ecede)
                                    )
                                    Text(
                                        it.updated_at.substring(0, 10),
                                        fontFamily = FontFamily.Default,
                                        fontWeight = FontWeight.Normal,
                                        letterSpacing = 0.5.sp,
                                        color = Color(0xFF8ecede)
                                    )


                                }
                            }
                        }
                    }, state = listState
                )
            }


        }
    }

}