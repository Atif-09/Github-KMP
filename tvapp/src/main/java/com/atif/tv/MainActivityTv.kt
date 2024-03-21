package com.atif.tv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.DrawerValue
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Icon
import androidx.tv.material3.NavigationDrawer
import androidx.tv.material3.NavigationDrawerItem
import androidx.tv.material3.NavigationDrawerItemDefaults
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import androidx.tv.material3.rememberDrawerState
import com.atif.tv.screens.TvHomeScreenUI
import com.atif.tv.screens.TvSearchScreenUI
import com.atif.tv.theme.GithubUsersTheme

class MainActivityTv : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubUsersTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = RectangleShape
                ) {
                    MainScreenUI()
                }
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun MainScreenUI() {

    /*   var urlList by remember { mutableStateOf<List<UsersDataClass>>(emptyList()) }

       val scope = rememberCoroutineScope()
       LaunchedEffect(Unit) {
           scope.launch {
               urlList = ApiClass().githubUsers()
               *//*println("Size of list ${data.size}")
            for (i in data) {
                println("User Github Login ${i.login}")

            }*//*

        }
    }*/
    var homeSelected by remember { mutableStateOf(true) }
    var searchSelected by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF001f25))
    )
    {

        NavigationDrawer(drawerState = rememberDrawerState(initialValue = DrawerValue.Open),
            modifier = Modifier
                .background(Color(0xFF0a2b34))
                .clip(
                    RoundedCornerShape(topEnd = 15.dp, bottomEnd = 15.dp)
                ),
            drawerContent = {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {

                    Spacer(Modifier.height(12.dp))
                    NavigationDrawerItem(
                        selected = homeSelected,
                        onClick = {
                            homeSelected = true
                            searchSelected = false
                        },
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.Home,
                                contentDescription = null
                            )
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            contentColor = Color.White,
                            inactiveContentColor = Color.White,
                            selectedContentColor = Color.White,
                            selectedContainerColor = Color(0xFF004b71),
                            containerColor = Color(0x33e8def8),
                            focusedContainerColor = Color(0xFF004b71),
                            disabledContainerColor = Color(0x33e8def8),
                            disabledContentColor = Color.White
                        )
                    ) {
                        Text(text = "Home")

                    }

                    NavigationDrawerItem(
                        selected = searchSelected,
                        onClick = {
                            searchSelected = true
                            homeSelected = false
                        },
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.Search,
                                contentDescription = null
                            )
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            contentColor = Color.White,
                            inactiveContentColor = Color.White,
                            selectedContentColor = Color.White,
                            selectedContainerColor = Color(0xFF004b71),
                            containerColor = Color(0x33e8def8),
                            focusedContainerColor = Color(0xFF004b71),
                            disabledContainerColor = Color(0x33e8def8),
                            disabledContentColor = Color.White
                        )

                    ) {
                        Text(text = "Search")

                    }
                }


            }
        ) {


        }

        if (homeSelected) {
            TvHomeScreenUI()
        }
        if (searchSelected) {
            TvSearchScreenUI()
        }
        /*NavigationBar(modifier = Modifier
     .align(Alignment.BottomCenter)
     .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
     tonalElevation = 9.dp,
     containerColor = Color(0xFF0a2b34),
     content = {
         NavigationBarItem(
             selected = selected,
             onClick = { selected = true },
             icon = { Icon(Icons.Default.Home, null) },
             modifier = Modifier,
             label = { Text("Home") },
             alwaysShowLabel = true,
             colors = NavigationBarItemDefaults.colors(

                 indicatorColor = if (selected) Color(0xFF004b71) else Color.Transparent,
                 disabledTextColor = Color.White,
                 disabledIconColor = Color.White,
                 selectedIconColor = Color.White,
                 unselectedIconColor = Color.White,
                 unselectedTextColor = Color.White,
                 selectedTextColor = Color.White
             )
         )

         NavigationBarItem(
             selected = !selected,
             onClick = { selected = false },
             icon = { Icon(Icons.Default.Search, null) },
             modifier = Modifier,
             label = { Text("Search") },
             alwaysShowLabel = true,
             colors = NavigationBarItemDefaults.colors(
                 indicatorColor = if (!selected) Color(0xFF004b71) else Color.Transparent,
                 disabledTextColor = Color.White,
                 disabledIconColor = Color.White,
                 selectedIconColor = Color.White,
                 unselectedIconColor = Color.White,
                 unselectedTextColor = Color.White,
                 selectedTextColor = Color.White

             )

         )
     }
 )*/
    }


}

@Preview(showBackground = true, showSystemUi = true, device = Devices.TV_720p)
@Composable
fun GreetingPreview() {
    GithubUsersTheme {
        MainScreenUI()
    }
}