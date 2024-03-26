package screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.AltRoute
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
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
import api.ApiClass
import com.seiko.imageloader.rememberImagePainter
import githubusers.composeapp.generated.resources.Res
import githubusers.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.launch
import model.UsersDataClass
import model.listOfPredefinedUsers
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MainScreenUI() {

    var homeSelected by remember { mutableStateOf(true) }
    var searchSelected by remember { mutableStateOf(false) }
    var trendingReposSelected by remember { mutableStateOf(false) }
    var trendingUsersSelected by remember { mutableStateOf(false) }

/*    val scope = rememberCoroutineScope()
    scope.launch {
        val user = ApiClass().getUser("seabdulbasit")
        println("Single User $user")
    }*/
    Box(modifier = Modifier.fillMaxSize().background(Color(0xFF001f25))) {
        if (homeSelected) {
            SmallDevicesHomeScreenUI()
        }
        if (searchSelected){
            SmallDeviceSearchScreenUI()
        }


        NavigationBar(modifier = Modifier.align(Alignment.BottomCenter),
            tonalElevation = 9.dp,
            containerColor = Color(0xFF0d2f3a),
            contentColor = Color(0xFF0a2b34),
            content = {
                NavigationBarItem(
                    selected = homeSelected,
                    onClick = {
                        homeSelected = true
                        searchSelected = false
                        trendingReposSelected = false
                        trendingUsersSelected = false

                    },
                    icon = { Icon(Icons.Default.Home, null) },
                    modifier = Modifier,
                    label = { Text("Home") },
                    alwaysShowLabel = true,
                    colors = NavigationBarItemDefaults.colors(

                        indicatorColor = if (homeSelected) Color(0xFF004b71) else Color.Transparent,
                        disabledTextColor = Color.White,
                        disabledIconColor = Color.White,
                        selectedIconColor = Color.White,
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White,
                        selectedTextColor = Color.White
                    )
                )

                NavigationBarItem(
                    selected = searchSelected,
                    onClick = {
                        homeSelected = false
                        searchSelected = true
                        trendingReposSelected = false
                        trendingUsersSelected = false
                    },
                    icon = { Icon(Icons.Default.Search, null) },
                    modifier = Modifier,
                    label = { Text("Search") },
                    alwaysShowLabel = true,
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = if (searchSelected) Color(0xFF004b71) else Color.Transparent,
                        disabledTextColor = Color.White,
                        disabledIconColor = Color.White,
                        selectedIconColor = Color.White,
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White,
                        selectedTextColor = Color.White

                    )

                )

                NavigationBarItem(
                    selected = trendingReposSelected,
                    onClick = {
                        homeSelected = false
                        searchSelected = false
                        trendingReposSelected = true
                        trendingUsersSelected = false

                    },
                    icon = { Icon(Icons.AutoMirrored.Default.TrendingUp, null) },
                    modifier = Modifier,
                    label = { Text("Repo") },
                    alwaysShowLabel = true,
                    colors = NavigationBarItemDefaults.colors(

                        indicatorColor = if (trendingReposSelected) Color(0xFF004b71) else Color.Transparent,
                        disabledTextColor = Color.White,
                        disabledIconColor = Color.White,
                        selectedIconColor = Color.White,
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White,
                        selectedTextColor = Color.White
                    )
                )

                NavigationBarItem(
                    selected = trendingUsersSelected,
                    onClick = {
                        homeSelected = false
                        searchSelected = false
                        trendingReposSelected = false
                        trendingUsersSelected = true
                    },
                    icon = { Icon(Icons.AutoMirrored.Default.TrendingUp, null) },
                    modifier = Modifier,
                    label = { Text("Users") },
                    alwaysShowLabel = true,
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = if (trendingUsersSelected) Color(0xFF004b71) else Color.Transparent,
                        disabledTextColor = Color.White,
                        disabledIconColor = Color.White,
                        selectedIconColor = Color.White,
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White,
                        selectedTextColor = Color.White

                    )

                )
            }
        )
    }


}