package screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import api.ApiClass
import kotlinx.coroutines.launch
import model.SearchUserDataClass

@Composable
fun LargeDeviceSearchScreenUI() {
    var text by rememberSaveable { mutableStateOf("") }
    var user by remember { mutableStateOf<SearchUserDataClass?>(null) }
    val scope = rememberCoroutineScope()

    Column(Modifier.fillMaxSize().semantics { isTraversalGroup = true }) {

        TextField(
            modifier = Modifier.fillMaxWidth(0.5f).padding(start = 12.dp, end = 12.dp, top = 18.dp)
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
                if (text.isNotEmpty()) {
                    IconButton(onClick = {
                        text = ""
                    }) {
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
    }
}