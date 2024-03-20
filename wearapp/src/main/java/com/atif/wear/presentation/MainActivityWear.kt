package com.atif.wear.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.SelfImprovement
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
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
import com.atif.wear.presentation.theme.GithubUsersTheme
import kotlinx.coroutines.launch
import model.UsersDataClass
import model.listOfPredefinedUsers

class MainActivityWear : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        setTheme(android.R.style.Theme_DeviceDefault)

        setContent {
            WearApp()
        }
    }
}

@Composable
fun WearApp() {
    val listState = rememberScalingLazyListState()
    var urlList by remember { mutableStateOf<List<UsersDataClass>>(emptyList()) }

    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        scope.launch {
            urlList = ApiClass().githubUsers()
            /*println("Size of list ${data.size}")
            for (i in data) {
                println("User Github Login ${i.login}")

            }*/

        }
    }


    GithubUsersTheme {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF001f25)),
            contentAlignment = Alignment.Center
        ) {
            /*TimeText()
            Greeting(greetingName = greetingName)*/


            Scaffold(
                timeText = { TimeText(modifier = Modifier.scrollAway(listState)) },
                vignette = { Vignette(vignettePosition = VignettePosition.TopAndBottom) },
                positionIndicator = {
                    PositionIndicator(
                        scalingLazyListState = listState
                    )
                }
            ) {
                var navigationItems by remember{ mutableStateOf(true) }


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
                        /*Row(horizontalArrangement = Arrangement.SpaceBetween) {
                            Card(
                                onClick = { navigationItems = true },
                                shape = RoundedCornerShape(100),
                                modifier = Modifier
                                    .size(45.dp)
                                    .padding(end = 2.dp),
                                backgroundPainter = CardDefaults.cardBackgroundPainter(
                                    startBackgroundColor = if (navigationItems) Color(0xFF004b71) else MaterialTheme.colors.primary.copy(alpha = 0.30f)
                                        .compositeOver(MaterialTheme.colors.background),
                                    endBackgroundColor = if (navigationItems) Color(0xFF004b71) else MaterialTheme.colors.primary.copy(alpha = 0.30f)
                                        .compositeOver(MaterialTheme.colors.background)
                                )
                            ) {
                                Box(modifier = Modifier.fillMaxSize()) {
                                    Icon(imageVector = Icons.Default.Home, contentDescription = null)
                                }
                            }

                            Card(
                                onClick = { navigationItems = false },
                                shape = RoundedCornerShape(100),
                                modifier = Modifier
                                    .size(45.dp)
                                    .padding(start = 2.dp),
                                backgroundPainter = CardDefaults.cardBackgroundPainter(
                                    startBackgroundColor = if (!navigationItems) Color(0xFF004b71) else MaterialTheme.colors.primary.copy(alpha = 0.30f)
                                        .compositeOver(MaterialTheme.colors.background),
                                    endBackgroundColor = if (!navigationItems) Color(0xFF004b71) else MaterialTheme.colors.primary.copy(alpha = 0.30f)
                                        .compositeOver(MaterialTheme.colors.background)
                                )
                            ) {
                                Box(modifier = Modifier.fillMaxSize()) {
                                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                                }
                            }
                        }*/

                    }


                    if(navigationItems){
                        val list = if (urlList.isEmpty()) listOfPredefinedUsers else urlList
                        items(list) { data ->
                            Chip(
                                modifier = Modifier.fillMaxWidth(),
                                colors = ChipDefaults.chipColors(
                                    backgroundColor = Color(0xFF0a2b34)
                                ),
                                onClick = { /* ... */ },
                                label = {
                                    Text(
                                        text = data.login.uppercase(),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                },
                                icon = {
                                    Box(modifier = Modifier
                                        .size(40.dp)
                                        .clip(RoundedCornerShape(100))
                                        .border(1.dp, Color(0x9932CD32), RoundedCornerShape(100))) {
                                        AsyncImage(data.avatar_url, null, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Fit)
                                    }


                                },
                            )
                        }
                    } else {
                        
                    }


                }, state = listState)

            }
        }
    }
}

@Composable
fun Greeting(greetingName: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary,
        text = stringResource(com.atif.wear.R.string.hello_world, greetingName)
    )
}

@Composable
fun Chips() {
    Chip(
        modifier = Modifier,
        onClick = { /* ... */ },
        label = {
            Text(
                text = "5 minute Meditation",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        icon = {
            Icon(
                imageVector = Icons.Rounded.SelfImprovement,
                contentDescription = "triggers meditation action",
                modifier = Modifier
            )
        },
    )
}

@Preview(device = Devices.WEAR_OS_LARGE_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp()
}