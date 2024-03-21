package com.atif.tv.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Card
import androidx.tv.material3.CardDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import api.ApiClass
import com.atif.tv.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalTvMaterial3Api::class)
@Composable
fun TvSearchScreenUI() {
    var text by rememberSaveable { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {
        Card(onClick = { /*TODO*/ }, colors = CardDefaults.colors(
            containerColor = Color(0xFF0a2b34),
        ), shape = CardDefaults.shape(RoundedCornerShape(100)),modifier = Modifier.fillMaxWidth(0.6f).padding(horizontal = 12.dp) ) {
            BasicTextField(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
                value = text,
                onValueChange = { updatedQuery -> text = updatedQuery },
                decorationBox = {
                    Box(
                        modifier = Modifier
                            .padding(vertical = 16.dp)
                            .padding(start = 20.dp),
                    ) {
                        it()
                        if (text.isEmpty()) {
                            Text(
                                modifier = Modifier.graphicsLayer { alpha = 0.6f },
                                text = stringResource(R.string.search_screen_et_placeholder),
                                style = MaterialTheme.typography.titleSmall
                            )
                        }
                    }

                })
        }

    }

}
