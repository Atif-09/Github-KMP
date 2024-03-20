package screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import api.ApiClass
import com.seiko.imageloader.rememberImagePainter
import kotlinx.coroutines.launch
import model.UsersDataClass
import model.listOfPredefinedUsers

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LargeMainScreenUI() {
    var urlList by remember { mutableStateOf<List<UsersDataClass>>(emptyList()) }
    var selected by remember { mutableStateOf(true) }

    val scope = rememberCoroutineScope()
    /*    scope.launch {
            urlList = ApiClass().githubUsers()
        }*/

    Row(modifier = Modifier.fillMaxSize().background(Color(0xFF001f25))) {
        ModalNavigationDrawer(drawerState = rememberDrawerState(initialValue = DrawerValue.Open),
            modifier = Modifier.width(300.dp).background(Color(0xFF0a2b34)).clip(
                RoundedCornerShape(topEnd = 15.dp, bottomEnd = 15.dp)
            ),
            drawerContent = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.background(Color(0xFF001f25)).clip(
                        RoundedCornerShape(topEnd = 15.dp, bottomEnd = 15.dp)
                    )
                ) {
                    Spacer(Modifier.height(12.dp))
                    NavigationDrawerItem(
                        selected = selected,
                        onClick = { selected = true },
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
                        selected = !selected,
                        onClick = { selected = false },
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
                /*ModalDrawerSheet(
                    modifier = Modifier,
                    drawerShape = RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp),
                    drawerContainerColor = Color(0xFF0a2b34),
                    content = {
                        Spacer(Modifier.height(12.dp))
                        NavigationDrawerItem(
                            label = { Text("Home") },
                            icon = { Icon(Icons.Rounded.Home, null) },
                            onClick = { selected = true },
                            selected = selected,
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedIconColor = Color.White,
                                unselectedIconColor = Color.White,
                                unselectedTextColor = Color.White,
                                selectedTextColor = Color.White,
                                selectedContainerColor = Color(0xFF004b71),
                                unselectedContainerColor = Color(0x33e8def8)

                            )

                        )
                        Spacer(Modifier.height(12.dp))
                        NavigationDrawerItem(
                            label = { Text("Search") },
                            icon = { Icon(Icons.Rounded.Search, null) },
                            onClick = { selected = false },
                            selected = !selected,
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedIconColor = Color.White,
                                unselectedIconColor = Color.White,
                                unselectedTextColor = Color.White,
                                selectedTextColor = Color.White,
                                selectedContainerColor = Color(0xFF004b71),
                                unselectedContainerColor = Color(0x33e8def8)

                            )

                        )
                    },
                    drawerTonalElevation = 9.dp
                )*/
                /*            NavigationDrawerItem(
                                label = { Text("Home") },
                                icon = { Icon(Icons.Rounded.Home, null) },
                                onClick = {selected = true},
                                selected = selected,
                                colors = NavigationDrawerItemDefaults.colors(
                                    selectedIconColor = Color.White,
                                    unselectedIconColor = Color.White,
                                    unselectedTextColor = Color.White,
                                    selectedTextColor = Color.White,
                                    selectedContainerColor = Color(0xFF004b71)

                                )

                            )
                            NavigationDrawerItem(
                                label = { Text("Search") },
                                icon = { Icon(Icons.Rounded.Search, null) },
                                onClick = {selected = false},
                                selected = !selected,
                                colors = NavigationDrawerItemDefaults.colors(
                                    selectedIconColor = Color.White,
                                    unselectedIconColor = Color.White,
                                    unselectedTextColor = Color.White,
                                    selectedTextColor = Color.White,
                                    selectedContainerColor = Color(0xFF004b71)

                                )

                            )*/


            },
            content = {


            })

        val list = urlList.ifEmpty { listOfPredefinedUsers }
        if (selected) {
            LazyVerticalGrid(columns = GridCells.Adaptive(300.dp)) {
                items(list) { user ->
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
        } else {
            var text by rememberSaveable { mutableStateOf("") }
            var active by rememberSaveable { mutableStateOf(false) }

            Box(Modifier.fillMaxSize().semantics { isTraversalGroup = true }) {
                DockedSearchBar(
                    modifier = Modifier.fillMaxWidth(0.5f).padding(12.dp)
                        .align(Alignment.TopCenter)
                        .semantics { traversalIndex = -1f },
                    query = text,
                    onQueryChange = { text = it },
                    onSearch = { active = false },
                    active = active,
                    onActiveChange = { active = it },
                    placeholder = { Text("Search a user", color = Color.White) },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = null,
                            tint = Color.White
                        )
                    },
                    trailingIcon = {
                        if (active) {
                            Icon(Icons.Default.Close,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.clickable {
                                    if (text.isNotEmpty()) {
                                        text = ""
                                    } else {
                                        active = false
                                    }

                                })
                        }
                    },
                    colors = SearchBarDefaults.colors(
                        containerColor = Color(0xFF0a2b34),
                        inputFieldColors = TextFieldDefaults.colors(
                            cursorColor = Color.White,
                            unfocusedTextColor = Color.White,
                            disabledLeadingIconColor = Color.White,
                            disabledTrailingIconColor = Color.White,
                            focusedLeadingIconColor = Color.White,
                            focusedTrailingIconColor = Color.White,
                            disabledTextColor = Color.White,
                            focusedTextColor = Color.White
                        )
                    ),
                ) {
                    repeat(4) { idx ->


                        Text(
                            "Abdul Basit",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF6a9fac),
                            modifier = Modifier.padding(start = 36.dp)
                        )



                }
            }

        }
    }

}


}