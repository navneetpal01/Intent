package com.example.intents

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.intents.ui.theme.IntentsTheme


class MainActivity : ComponentActivity(){
    //Types of Intents
    //1- Implicit - used in our own apps
    //2- Explicit - to launch an activity of another app

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

            }
        }
    }

}