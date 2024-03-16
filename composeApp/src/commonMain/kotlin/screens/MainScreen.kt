package screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import api.ApiClass
import com.seiko.imageloader.rememberImagePainter
import githubusers.composeapp.generated.resources.Res
import githubusers.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.launch
import model.UsersDataClass
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MainScreenUI() {

    var urlList by remember { mutableStateOf<List<UsersDataClass>>(emptyList()) }
    var selected by remember { mutableStateOf(true) }

    val scope = rememberCoroutineScope()
    scope.launch {
        urlList = ApiClass().githubUsers()
        /*println("Size of list ${data.size}")
        for (i in data) {
            println("User Github Login ${i.login}")

        }*/

    }
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(urlList) { user ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(9.dp),
                    shape = RoundedCornerShape(9.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF0a2b34)
                    ),

                    ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Card(
                            modifier = Modifier.size(81.dp).padding(12.dp),
                            shape = RoundedCornerShape(100),
                            border = BorderStroke(1.dp, Color(0xFF3d7e31))
                        ) {

                            /*Image(
                                painterResource(Res.drawable.compose_multiplatform),
                                null,
                                modifier = Modifier.fillMaxSize()
                            )*/
                            Image(
                                rememberImagePainter(user.avatar_url),
                                null,
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        Column {
                            Text(
                                user.login.uppercase(),
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF6a9fac)
                            )
                            Text(
                                "ID = ${user.id}",
                                color = Color(0xFF2c545e),
                                modifier = Modifier.padding(bottom = 9.dp)
                            )
                        }
                    }

                }
            }
        }
        NavigationBar(modifier = Modifier.align(Alignment.BottomCenter).clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
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

                        indicatorColor = if (selected)Color(0xFF004b71) else Color.Transparent,
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
                        indicatorColor = if (!selected)Color(0xFF004b71) else Color.Transparent,
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