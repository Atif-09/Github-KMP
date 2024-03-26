package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LargeMainScreenUI() {
    var homeSelected by remember { mutableStateOf(true) }
    var searchSelected by remember { mutableStateOf(false) }

    Row(modifier = Modifier.fillMaxSize().background(Color(0xFF001f25))) {
        PermanentNavigationDrawer(
            modifier = Modifier.width(300.dp).background(Color(0xFF0a2b34)),
            drawerContent = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxHeight(1f).background(Color(0xFF0a2b34)).clip(
                        RoundedCornerShape(topEnd = 15.dp, bottomEnd = 15.dp)
                    )
                ) {
                    Spacer(Modifier.height(12.dp))
                    NavigationDrawerItem(
                        selected = homeSelected,
                        onClick = {
                            homeSelected = true
                            searchSelected = false
                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Rounded.Home,
                                contentDescription = null
                            )
                        },
                        label = { Text("Home") },
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = Color(0xFF004b71),
                            unselectedContainerColor = Color(0x33e8def8),
                            unselectedTextColor = Color.White,
                            unselectedIconColor = Color.White,
                            selectedIconColor = Color.White,
                            selectedTextColor = Color.White

                        )
                    )

                    NavigationDrawerItem(
                        selected = searchSelected,
                        onClick = {
                            homeSelected = false
                            searchSelected = true
                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Rounded.Search,
                                contentDescription = null
                            )
                        },
                        label = { Text("Search") },
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = Color(0xFF004b71),
                            unselectedContainerColor = Color(0x33e8def8),
                            unselectedTextColor = Color.White,
                            unselectedIconColor = Color.White,
                            selectedIconColor = Color.White,
                            selectedTextColor = Color.White
                        )

                    )
                }
            },
            content = {


            })

        if (homeSelected) {
            LargeDevicesHomeScreenUI()
        }
        if (searchSelected) {
            LargeDeviceSearchScreenUI()
        }


    }


}