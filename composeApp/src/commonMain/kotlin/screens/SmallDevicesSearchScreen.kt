package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import api.ApiClass
import com.seiko.imageloader.rememberImagePainter
import kotlinx.coroutines.launch
import model.SearchUserDataClass

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallDeviceSearchScreenUI() {
    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }
/*    var user by remember { mutableStateOf<SearchUserDataClass?>(null) }
    val scope = rememberCoroutineScope()
    scope.launch {
        user = ApiClass().getUser("seabdulbasit")
    }*/

    Column(Modifier.fillMaxSize().semantics { isTraversalGroup = true }) {
        DockedSearchBar(
            modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 36.dp)
                .align(Alignment.CenterHorizontally)
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
                    Icon(
                        Icons.Default.Close,
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


        Box(modifier = Modifier.fillMaxSize().padding(top = 12.dp)){

            Card(modifier = Modifier.fillMaxSize().padding(top = 81.dp), shape = RoundedCornerShape(18.dp), colors = CardDefaults.cardColors(
                containerColor = Color(0xFF0d2f3a)
            )){

            }

            Card(modifier = Modifier.size(150.dp).align(Alignment.TopCenter), shape = RoundedCornerShape(100)){
                Image(rememberImagePainter("https://avatars.githubusercontent.com/u/33172684?v=4"),null, contentScale = ContentScale.Crop)

            }
        }



    }

}