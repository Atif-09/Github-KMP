package com.atif.tv.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.grid.TvGridCells
import androidx.tv.foundation.lazy.grid.TvLazyVerticalGrid
import androidx.tv.foundation.lazy.grid.items
import androidx.tv.material3.Card
import androidx.tv.material3.CardDefaults
import androidx.tv.material3.DrawerValue
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Icon
import androidx.tv.material3.NavigationDrawer
import androidx.tv.material3.NavigationDrawerItem
import androidx.tv.material3.NavigationDrawerItemDefaults
import androidx.tv.material3.Text
import androidx.tv.material3.rememberDrawerState
import api.ApiClass
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import model.UsersDataClass
import model.listOfPredefinedUsers

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun TvHomeScreenUI() {
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

    val list = urlList.ifEmpty { listOfPredefinedUsers }
    TvLazyVerticalGrid(columns = TvGridCells.Adaptive(300.dp), content = {
        items(list) { users ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(9.dp),
                shape = CardDefaults.shape(RoundedCornerShape(12.dp)),
                colors = CardDefaults.colors(
                    containerColor = Color(0xFF0a2b34)
                ),
                content = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Card(
                            modifier = Modifier
                                .size(81.dp)
                                .padding(12.dp),
                            shape = CardDefaults.shape(RoundedCornerShape(100)),
                            border = CardDefaults.border(),
                            onClick = {}
                        ) {

                            AsyncImage(
                                model = users.avatar_url,
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        Column {
                            Text(
                                users.login,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF6a9fac)
                            )
                            Text(
                                users.id.toString(),
                                color = Color(0xFF2c545e),
                                modifier = Modifier.padding(bottom = 9.dp)
                            )
                        }
                    }
                },
                onClick = {}

            )
        }
    })


}