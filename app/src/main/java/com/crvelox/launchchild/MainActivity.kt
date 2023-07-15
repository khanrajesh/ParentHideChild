package com.crvelox.launchchild

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import com.crvelox.launchchild.ui.theme.LaunchChildTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            val dataObject = intent.getStringExtra("data").toString()
            Log.d("dataObject", dataObject)

            setContent {
                Box(  modifier = Modifier
                    .fillMaxSize()
                    .background(White), contentAlignment = Alignment.Center) {
                    Column {
                        Text("child")
                        Text(dataObject)
                    }
                }

            }


        } catch (e: Exception) {
            setContent {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(White),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Unable to get Data Please Pass all the required data")
                }
            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LaunchChildTheme {
        Greeting("Android")
    }
}