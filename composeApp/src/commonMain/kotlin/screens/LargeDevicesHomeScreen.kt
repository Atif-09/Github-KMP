package screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import api.ApiClass
import com.seiko.imageloader.rememberImagePainter
import kotlinx.coroutines.launch
import model.UsersDataClass
import model.listOfPredefinedUsers

@Composable
fun LargeDevicesHomeScreenUI(){
    var urlList by remember { mutableStateOf<List<UsersDataClass>>(emptyList()) }

    val scope = rememberCoroutineScope()
       /* scope.launch {
            urlList = ApiClass().githubUsers()
        }*/

    val list = urlList.ifEmpty { listOfPredefinedUsers }
        LazyVerticalGrid(columns = GridCells.Adaptive(300.dp)) {
            itemsIndexed(list) { index, user ->

                val imageBorderColor = if (index % 3 ==0) Color(0x99F44336) else Color(0xFF3d7e31)
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
                            border = BorderStroke(1.dp, imageBorderColor)
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
}