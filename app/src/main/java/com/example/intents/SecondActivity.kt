package com.example.intents

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.example.intents.ui.theme.IntentsTheme


class SecondActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            IntentsTheme {
                Text(text = "Second Activity")
            }
        }
    }
    
}