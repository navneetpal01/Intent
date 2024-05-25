package com.example.intents

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.intents.ui.theme.IntentsTheme


class MainActivity : ComponentActivity(){
    //Types of Intents
    //1- Implicit - Implicit intents are more general. Instead of specifying a particular component, they declare a generic action (like "view" or "dial") that needs to be performed
    //2- Explicit - to launch an activity of another  our own or another app

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

}