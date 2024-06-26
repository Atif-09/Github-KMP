import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import api.ApiClass
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import githubusers.composeapp.generated.resources.Res
import githubusers.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.launch
import screens.LargeMainScreenUI
import screens.MainScreenUI

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        val scope = rememberCoroutineScope()
        /*scope.launch {
            val data = ApiClass().githubUsers()
            println("Size of list ${data.size}")
            for (i in data){
                println("User Github Login ${i.login}")

            }

        }*/
        Column(modifier = Modifier.fillMaxSize()) {
            if (getPlatform().name == "Desktop") {
                LargeMainScreenUI()
            } else {
                Navigator(SmallDevicesMainScreen()){
                    SlideTransition(it)
                }
                //MainScreenUI()
            }
        }
        /* Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
             Button(onClick = { showContent = !showContent }) {
                 Text("Click me!")
             }
             AnimatedVisibility(showContent) {
                 val greeting = remember { Greeting().greet() }
                 Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                     Image(painterResource(Res.drawable.compose_multiplatform), null)
                     Text("Compose: $greeting")
                 }
             }
         }*/
    }
}

class SmallDevicesMainScreen() : Screen {

    @Composable
    override fun Content() {
        MainScreenUI()
    }
}