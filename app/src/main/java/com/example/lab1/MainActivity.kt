package com.example.lab1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab1.ui.theme.Lab1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1Theme {
                // remember state of randomSentence
                // ensures that randomSentence persists across UI updates
                var randomSentence by remember { mutableStateOf("") }
                // UI Stuff
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(20.dp)
                ) {
                    BackgroundImage()
                    Button(onClick = {
                        // make button call randomSentence function then display the random text
                        Toast.makeText(     // <- just experimenting with Toast text
                            applicationContext,
                            "You clicked the Button.",
                            Toast.LENGTH_LONG).show()

                        val sentence = randomSentences()
                        randomSentence = sentence
                    }) {
                        Text("Submit Request")
                    }
                    // just some basic error handling, could implement some other event to happen when statement is false
                    if (randomSentence.isNotEmpty()) {
                        Text(text = "$randomSentence")
                    }
                }
            }
        }
    }
}

@Composable
fun BackgroundImage() {
    // image container
    Box(
        modifier = Modifier
            .width(300.dp)
            .height(350.dp)
    ) {
        // image reference and some alignment stuff
        Image(
            painter = painterResource(R.drawable.asdasdasdsad),
            contentDescription = "BG Image",
            modifier = Modifier
                .fillMaxSize() // fill the box
                .align(Alignment.Center)
        )
    }
}

// Called when the "Submit Request" button is pressed
fun randomSentences(): String {
    val sentences = arrayOf(
        "I really dislike apple pie",
        "Blueberry pie is great!",
        "I have really bad ADHD",
        "I started speaking when I was about a year old",
        "I could read when I was five years old",
        "I really enjoy going to the gym",
        "I used to write short, fictional stories",
        "I used to draw a lot",
        "I'm fascinated by most facets of video game creation",
        "I've always wanted to write and illustrate children's books"
    )
    return sentences.random()
}