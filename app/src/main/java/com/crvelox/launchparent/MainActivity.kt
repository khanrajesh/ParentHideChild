package com.crvelox.launchparent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.crvelox.launchparent.ui.theme.LaunchParentTheme
import com.velox.lazeir.utils.outlet.startOuterActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LaunchParentTheme {
                    Box(
                        Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                    ) {
                        Button(onClick = {
                            val packageName = "com.crvelox.launchchild"
                            val activityName = "MainActivity"
                            val dataList = listOf(Pair("data", "dataTo"))
                            this@MainActivity.startOuterActivity(packageName, activityName, dataList)
                        }) {
                            Text(text = "To Child")
                        }
                    }
            }
        }
    }
}