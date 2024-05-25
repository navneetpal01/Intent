package com.example.intents

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.intents.ui.theme.IntentsTheme


class MainActivity : ComponentActivity(){
    private val viewModel by viewModels<ImageViewModel>()
    //Types of Intents
    //1- Implicit - Opening other apps sending email texts
    //2- Explicit - to launch an activity of another  our own or another app
    //3- Intent Chooser - Register your app to receive text images it's like registering your app to receive Implicit Intents
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
            IntentsTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    viewModel.uri?.let {

                    AsyncImage(
                        model = viewModel.uri,
                        contentDescription = "Image"
                    )
                    }

                    Button(
                        onClick = { 
                            Intent(applicationContext,SecondActivity::class.java).also {
                                startActivity(it)
                            }
                        }
                    ) {
                        Text(text = "Click Me")
                    }
                }
            }
        }
    }

    //Enable launch mode from the manifest
    //Do not works will work on it latter
    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        val uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Intent.EXTRA_STREAM,Uri::class.java)
        } else {
            intent.getParcelableExtra(Intent.EXTRA_STREAM)
        }
        viewModel.updateUri(uri)
    }

}