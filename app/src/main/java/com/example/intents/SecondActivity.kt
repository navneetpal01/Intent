package com.example.intents

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.intents.ui.theme.IntentsTheme


class SecondActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntentsTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(text = "Second Activity")
                    Button(
                        onClick = {
//                            Open YouTube App It's Implicit Intent
//                            Intent(Intent.ACTION_MAIN).also {
//                                it.`package` = "com.google.android.youtube"
//                                try {
//                                    startActivity(it)
//                                }catch (e : ActivityNotFoundException){
//                                    e.printStackTrace()
//                                }
//                                startActivity(it)
//                            }
                            val intent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_EMAIL, arrayOf("test@test.com"))
                                putExtra(Intent.EXTRA_SUBJECT, "This is my subject")
                                putExtra(Intent.EXTRA_TEXT,"This is the content of my email")
                            }
                            if (intent.resolveActivity(packageManager) != null){
                                startActivity(intent)
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