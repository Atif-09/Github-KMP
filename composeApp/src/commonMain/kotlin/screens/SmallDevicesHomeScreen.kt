package screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.seiko.imageloader.rememberImagePainter
import model.UsersDataClass
import model.listOfPredefinedUsers

@Composable
fun SmallDevicesHomeScreenUI() {
    var urlList by remember { mutableStateOf<List<UsersDataClass>>(emptyList()) }
    val scope = rememberCoroutineScope()
    /* scope.launch {
         urlList = ApiClass().githubUsers()

     }*/

    val navigator = LocalNavigator.currentOrThrow

    val list = urlList.ifEmpty { listOfPredefinedUsers }

    LazyColumn {
        items(list) { user ->
            Card(
                modifier = Modifier.fillMaxWidth().padding(9.dp),
                shape = RoundedCornerShape(9.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF0d2f3a)
                ),
                onClick = {
                    navigator.push(SmallHomeToDetailScreenNav(user.login))
                }
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 12.dp)) {
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

                        CompositionLocalProvider(
                            LocalContentColor provides LocalContentColor.current.copy(alpha = 1f)
                        ) {

                            Text(
                                user.login.uppercase(),
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                letterSpacing = 0.5.sp,
                                color = Color(0xFF8ecede)
                            )
                        }

                        CompositionLocalProvider(LocalContentColor provides LocalContentColor.current.copy(alpha = 0.4F)) {
                            Text(
                                "ID = ${user.id}",
                                color = Color(0xFF345e69),
                                style = MaterialTheme.typography.bodyMedium

                            )
                        }


                    }
                }

            }
        }
    }

}

class SmallHomeToDetailScreenNav(private val userName: String) : Screen {

    @Composable
    override fun Content() {
        SmallDeviceShowDetailsUI(userName)
    }
}