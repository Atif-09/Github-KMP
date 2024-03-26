package com.atif.wear.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import androidx.wear.compose.material.items
import androidx.wear.compose.material.rememberScalingLazyListState
import androidx.wear.compose.material.scrollAway
import api.ApiClass
import coil.compose.AsyncImage
import com.atif.wear.presentation.singleton.LoginObject
import com.atif.wear.presentation.theme.GithubUsersTheme
import kotlinx.coroutines.launch
import model.UsersDataClass
import model.listOfPredefinedUsers

@Composable
fun WearMainScreenUI(navController: NavHostController) {

    val listState = rememberScalingLazyListState()
    var urlList by remember { mutableStateOf<List<UsersDataClass>>(emptyList()) }

    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        scope.launch {
            urlList = ApiClass().githubUsers()
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


            ScalingLazyColumn(content = {
                item {

                    Button(
                        modifier = Modifier
                            .size(ButtonDefaults.DefaultButtonSize)
                            .align(Alignment.Center),
                        onClick = { /* ... */ },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xFF004b71),
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Home,
                            contentDescription = "triggers phone action",
                            modifier = Modifier
                        )
                    }

                }


                val list = urlList.ifEmpty { listOfPredefinedUsers }
                items(list) { data ->
                    Chip(
                        modifier = Modifier.fillMaxWidth(),
                        colors = ChipDefaults.chipColors(
                            backgroundColor = Color(0xFF0a2b34)
                        ),
                        onClick = { navController.navigate("details")
                                  LoginObject.loginId = data.login
                                  },
                        label = {
                            Column {

                                Text(
                                    text = data.login.uppercase(),
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 16.sp,
                                    lineHeight = 24.sp,
                                    letterSpacing = 0.5.sp,
                                    color = Color(0xFF8ecede)
                                )
                                Text(
                                    "ID = ${data.id}",
                                    color = Color(0xFF345e69),
                                    style = MaterialTheme.typography.body2

                                )
                            }

                        },
                        icon = {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(RoundedCornerShape(100))
                                    .border(1.dp, Color(0x9932CD32), RoundedCornerShape(100))
                            ) {
                                AsyncImage(
                                    data.avatar_url,
                                    null,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Fit
                                )
                            }


                        },
                    )
                }


            }, state = listState)

        }
    }
}

