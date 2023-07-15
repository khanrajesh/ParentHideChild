package com.crvelox.launchparent

import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.crvelox.launchparent.ui.theme.LaunchParentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LaunchParentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                    ) {

                        Button(onClick = {
                            val pack = "com.crvelox.launchchild"
                            val action = "com.example.ACTION_CUSTOM_ACTION" 

                            try {
                                val launchIntent = Intent(action)
                                launchIntent.setPackage(pack)
                                launchIntent.putExtra("data", "launchIntent")
                                startActivity(launchIntent)
                            } catch (e: ActivityNotFoundException) {
                                // Target app not found or doesn't support the custom action, handle the error or notify the user
                            }
                        }) {
                            Text(text = "To Child")

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LaunchParentTheme {
        Greeting("Android")
    }
}