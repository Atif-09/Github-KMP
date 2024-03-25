package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import api.ApiClass
import com.seiko.imageloader.rememberImagePainter
import kotlinx.coroutines.launch
import model.SearchUserDataClass

@Composable
fun SmallDeviceShowDetailsUI(userData:String) {
    var user by remember { mutableStateOf<SearchUserDataClass?>(null) }
    val scope = rememberCoroutineScope()
    scope.launch {
        user = ApiClass().getUser(userData)
    }
    var text by rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current



    Column(Modifier.fillMaxSize().background(Color(0xFF001f25))) {
        Spacer(modifier = Modifier.height(54.dp))

        user?.let {
            Box(modifier = Modifier.fillMaxSize().padding(top = 12.dp)) {

                Card(
                    modifier = Modifier.fillMaxSize().padding(top = 100.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF0d2f3a)
                    )
                ) {
                    Column(modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.padding(top = 72.dp),

                            ) {
                            Column(
                                modifier = Modifier.padding(horizontal = 18.dp),
                                verticalArrangement = Arrangement.spacedBy(18.dp) // Aligns children to start and end
                            ) {
                                Text(
                                    "Name:",
                                    modifier = Modifier,
                                    fontSize = 16.sp,
                                    lineHeight = 24.sp,
                                    letterSpacing = 0.5.sp,
                                    color = Color(0xFF8ecede)
                                )
                                Text(
                                    "Repos:",
                                    modifier = Modifier,
                                    fontSize = 16.sp,
                                    lineHeight = 24.sp,
                                    letterSpacing = 0.5.sp,
                                    color = Color(0xFF8ecede)
                                )

                                Text(
                                    "Gists:",
                                    modifier = Modifier,
                                    fontSize = 16.sp,
                                    lineHeight = 24.sp,
                                    letterSpacing = 0.5.sp,
                                    color = Color(0xFF8ecede)
                                )

                                Text(
                                    "Followers:",
                                    modifier = Modifier,
                                    fontSize = 16.sp,
                                    lineHeight = 24.sp,
                                    letterSpacing = 0.5.sp,
                                    color = Color(0xFF8ecede)
                                )

                                Text(
                                    "Following:",
                                    modifier = Modifier,
                                    fontSize = 16.sp,
                                    lineHeight = 24.sp,
                                    letterSpacing = 0.5.sp,
                                    color = Color(0xFF8ecede)
                                )

                                Text(
                                    "Created At:",
                                    modifier = Modifier,
                                    fontSize = 16.sp,
                                    lineHeight = 24.sp,
                                    letterSpacing = 0.5.sp,
                                    color = Color(0xFF8ecede)
                                )

                                Text(
                                    "Updated At:",
                                    modifier = Modifier,
                                    fontSize = 16.sp,
                                    lineHeight = 24.sp,
                                    letterSpacing = 0.5.sp,
                                    color = Color(0xFF8ecede)
                                )


                            }

                            Column(
                                modifier = Modifier.padding(horizontal = 18.dp),
                                verticalArrangement = Arrangement.spacedBy(18.dp) // Aligns children to start and end
                            ) {
                                Text(
                                    it.name,
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.Normal,
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
                                Text(
                                    it.public_gists.toString(),
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.Normal,
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

                                Text(
                                    it.following.toString(),
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 16.sp,
                                    lineHeight = 24.sp,
                                    letterSpacing = 0.5.sp,
                                    color = Color(0xFF8ecede)
                                )

                                Text(
                                    it.created_at.substring(0, 10),
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 16.sp,
                                    lineHeight = 24.sp,
                                    letterSpacing = 0.5.sp,
                                    color = Color(0xFF8ecede)
                                )

                                Text(
                                    it.updated_at.substring(0, 10),
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


                }

                Card(
                    modifier = Modifier.size(150.dp).align(Alignment.TopCenter),
                    shape = RoundedCornerShape(100)
                ) {
                    Image(
                        rememberImagePainter(it.avatar_url),
                        null,
                        contentScale = ContentScale.Fit,

                    )

                }
            }
        }


    }
}