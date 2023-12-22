package com.example.jessschristmasstory

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.foundation.border
import androidx.compose.ui.Alignment
import GameTexts


class TitleScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TitleScreenContent()
        }
    }

    @Preview
    @Composable
    fun TitleScreenContent() {
        val terminalGreen = Color(0xFF33FF33)
        var buttonColor by remember { mutableStateOf(Color.Transparent) }
        var textColor by remember { mutableStateOf(terminalGreen) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(16.dp)
        ) {
            Text(
                text = GameTexts.titleText,
                color = terminalGreen,
                fontFamily = FontFamily.Monospace,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, terminalGreen) // Add border to the Box

            ) {
                Button(
                    onClick = {
                        startActivity(Intent(this@TitleScreen, GameScreen::class.java))
                        buttonColor = Color(0xFF33FF33) // Change button color
                        textColor = Color.Black
                    },
                    modifier = Modifier
                        .align(Alignment.Center)
                        .background(buttonColor),
                    shape = RectangleShape, // Use RectangleShape for square corners
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent,
                        contentColor = textColor
                    )
                ) {
                    Text(
                        text = "Start your festive adventure",
                        color = textColor,
                        fontFamily = FontFamily.Monospace,
                        textAlign = TextAlign.Center // Center-align the text
                    )
                }
            }
            Text(
                text = GameTexts.titleSanta,
                textAlign = TextAlign.Center,
                color = terminalGreen,
                fontFamily = FontFamily.Monospace,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

        }

    }
}