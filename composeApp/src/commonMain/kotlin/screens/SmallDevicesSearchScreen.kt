package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import api.ApiClass
import com.seiko.imageloader.rememberImagePainter
import kotlinx.coroutines.launch
import model.SearchUserDataClass

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallDeviceSearchScreenUI() {
    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }
    var user by remember { mutableStateOf<SearchUserDataClass?>(null) }
    val scope = rememberCoroutineScope()


    Column(Modifier.fillMaxSize().semantics { isTraversalGroup = true }) {
        TextField(
            modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, top = 36.dp)
                .align(Alignment.CenterHorizontally),
            value = text,
            onValueChange = { text = it },
            placeholder = { Text("Search a user", color = Color.White) },
            leadingIcon = {
                IconButton(onClick = {
                    scope.launch {
                        user = ApiClass().getUser(text)
                    }
                }) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        tint = Color.White
                    )
                }

            },
            trailingIcon = {
                if (text.isNotEmpty()){
                    IconButton(onClick = {
                        text = ""
                    }){
                        Icon(
                            Icons.Default.Close,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                        )
                    }
                }


            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF0a2b34),
                unfocusedContainerColor = Color(0xFF0a2b34),
                disabledContainerColor = Color(0xFF0a2b34),
                cursorColor = Color.White,
                unfocusedTextColor = Color.White,
                disabledLeadingIconColor = Color.White,
                disabledTrailingIconColor = Color.White,
                focusedLeadingIconColor = Color.White,
                focusedTrailingIconColor = Color.White,
                disabledTextColor = Color.White,
                focusedTextColor = Color.White,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent

            ),
            shape = RoundedCornerShape(50)
        )
        user?.let {
            Box(modifier = Modifier.fillMaxSize().padding(top = 12.dp)) {

                Card(
                    modifier = Modifier.fillMaxSize().padding(top = 81.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF0d2f3a)
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(top = 72.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 18.dp),
                            horizontalArrangement = Arrangement.spacedBy(18.dp) // Aligns children to start and end
                        ) {
                            Text(
                                "Name",
                                modifier = Modifier,
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                letterSpacing = 0.5.sp,
                                color = Color(0xFF8ecede)
                            )
                            Text(
                                it.name,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                letterSpacing = 0.5.sp,
                                color = Color(0xFF8ecede)
                            )
                        }

                        Row(
                            modifier = Modifier.padding(horizontal = 18.dp),
                            horizontalArrangement = Arrangement.spacedBy(18.dp) // Aligns children to start and end
                        ) {
                            Text(
                                "Repos",
                                modifier = Modifier,
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                letterSpacing = 0.5.sp,
                                color = Color(0xFF8ecede)
                            )
                            Text(
                                it.public_repos.toString(),
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                letterSpacing = 0.5.sp,
                                color = Color(0xFF8ecede)
                            )
                        }

                        Row(
                            modifier = Modifier.padding(horizontal = 18.dp),
                            horizontalArrangement = Arrangement.spacedBy(18.dp) // Aligns children to start and end
                        ) {
                            Text(
                                "Gists",
                                modifier = Modifier,
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                letterSpacing = 0.5.sp,
                                color = Color(0xFF8ecede)
                            )
                            Text(
                                it.public_gists.toString(),
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                letterSpacing = 0.5.sp,
                                color = Color(0xFF8ecede)
                            )
                        }
                        Row(
                            modifier = Modifier.padding(horizontal = 18.dp),
                            horizontalArrangement = Arrangement.spacedBy(18.dp) // Aligns children to start and end
                        ) {
                            Text(
                                "Followers",
                                modifier = Modifier,
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                letterSpacing = 0.5.sp,
                                color = Color(0xFF8ecede)
                            )
                            Text(
                                it.followers.toString(),
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                letterSpacing = 0.5.sp,
                                color = Color(0xFF8ecede)
                            )
                        }
                        Row(
                            modifier = Modifier.padding(horizontal = 18.dp),
                            horizontalArrangement = Arrangement.spacedBy(18.dp) // Aligns children to start and end
                        ) {
                            Text(
                                "Following",
                                modifier = Modifier,
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                letterSpacing = 0.5.sp,
                                color = Color(0xFF8ecede)
                            )
                            Text(
                                it.following.toString(),
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                letterSpacing = 0.5.sp,
                                color = Color(0xFF8ecede)
                            )
                        }

                        Row(
                            modifier = Modifier.padding(horizontal = 18.dp),
                            horizontalArrangement = Arrangement.spacedBy(18.dp) // Aligns children to start and end
                        ) {
                            Text(
                                "Created",
                                modifier = Modifier,
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                letterSpacing = 0.5.sp,
                                color = Color(0xFF8ecede)
                            )
                            Text(
                                it.created_at.substring(0,10),
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                letterSpacing = 0.5.sp,
                                color = Color(0xFF8ecede)
                            )
                        }

                        Row(
                            modifier = Modifier.padding(horizontal = 18.dp),
                            horizontalArrangement = Arrangement.spacedBy(18.dp) // Aligns children to start and end
                        ) {
                            Text(
                                "Updated",
                                modifier = Modifier,
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                letterSpacing = 0.5.sp,
                                color = Color(0xFF8ecede)
                            )
                            Text(
                                it.updated_at.substring(0,10),
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                letterSpacing = 0.5.sp,
                                color = Color(0xFF8ecede)
                            )
                        }
                    }


                }

                Card(
                    modifier = Modifier.size(150.dp).align(Alignment.TopCenter),
                    shape = RoundedCornerShape(100)
                ) {
                    Image(
                        rememberImagePainter("https://avatars.githubusercontent.com/u/33172684?v=4"),
                        null,
                        contentScale = ContentScale.Crop
                    )

                }
            }
        }


    }

}