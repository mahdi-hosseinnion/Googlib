package com.ssmmhh.googlib.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ssmmhh.googlib.ui.theme.GoogLibTheme

class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogLibTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting( mainViewModel.bookListStateFlow.collectAsState())
                }
            }
        }
        mainViewModel.fetchBookListByQuery("Clean code")
    }
}

@Composable
fun Greeting(bookList: State<List<String?>>, modifier: Modifier = Modifier) {
    Text(
        text = "List of books are: \n ${
            buildString { bookList.value.forEach { this.append("\n$it") } }
        }",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GoogLibTheme {
        val bookList = remember {
            mutableStateOf(listOf("The art of something", "the art of nothing"))
        }
        Greeting(bookList)
    }
}