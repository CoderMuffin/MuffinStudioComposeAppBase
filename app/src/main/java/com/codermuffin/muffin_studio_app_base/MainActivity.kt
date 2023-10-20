package com.codermuffin.muffin_studio_app_base;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log;
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Button;
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top
                    ) {
                        val items = (1..10).map { "Item $it" }
                        MyRecyclerView(elements = items)
                    }
                }
            }
        }
    }
}

@Composable
fun MyRecyclerView(elements: List<String>) {
    LazyColumn {
        items(elements.size) { index ->
            ListItem(text = elements[index])
        }
    }
}

@Composable
fun ListItem(text: String) {
    Button(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        onClick = { Log.d("MainActivity", "Clicked $text") }
    ) {
        Text(text)
    }
}

