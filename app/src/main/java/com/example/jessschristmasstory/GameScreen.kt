package com.example.jessschristmasstory

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// I would really like to add the following functions to this:
// A save function so that you can close and come back to it
// An updated app icon because quite frankly I did all of this and then didn't update the app icon?? who am I
// The ability to share your ending?
// Images

class GameScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameScreenContent()
        }
    }

    @Preview
    @Composable
    fun GameScreenContent() {
        val goTitleScreen = {
            startActivity(Intent(this@GameScreen, TitleScreen::class.java))
        }

        val story = remember { Story(goTitleScreen) }
        // I know I should be setting these in styles but that kept breaking so I AM SORRY
        var buttonColor by remember { mutableStateOf(Color.Transparent) }
        var textColor by remember { mutableStateOf(Color(0xFF33FF33)) }
        var showResetDialog by remember { mutableStateOf(false) }

        // Function to reset the game state
        val resetGameState = {
            // Resetting variables to false
            story.ateFood = false
            story.getsMagicWord = false
            story.getsMysteryBag = false
            story.getsBackpack = false
            story.getsCompanion = false
            story.getsPresent = false

            // After resetting, go to the starting point
            goTitleScreen()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start
            ) {
                Button(
                    onClick = { showResetDialog = true },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
                ) {
                    Text("<", color = textColor, fontFamily = FontFamily.Monospace)
                }
            }

            if (showResetDialog) {
                AlertDialog(
                    onDismissRequest = { showResetDialog = false },
                    title = {
                        Text(
                            "Confirm complete game reset",
                            fontFamily = FontFamily.Monospace,
                            color = textColor
                        )
                    },
                    text = {
                        Text(
                            "Are you sure you want to start over? \n\nSometimes you have to fail to succeed, Jess.\n\nThis will completely reset any progress you have made in the game.",
                            fontFamily = FontFamily.Monospace,
                            color = textColor
                        )
                    },
                    backgroundColor = Color.Black,
                    confirmButton = {
                        TextButton(
                            onClick = {
                                showResetDialog = false
                                resetGameState()
                            }
                        ) {
                            Text("Yes", color = textColor, fontFamily = FontFamily.Monospace)
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = { showResetDialog = false }
                        ) {
                            Text("No", color = textColor, fontFamily = FontFamily.Monospace)
                        }
                    },
                    modifier = Modifier.border(1.dp, Color(0xFF33FF33))
                )
            }

            Text(
                text = story.gameText,
                color = textColor,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(Color(0xFF33FF33))
            )
            story.choiceTexts.forEachIndexed { index, choiceText ->
                if (choiceText.isNotEmpty()) {
                    Button(
                        onClick = {
                            story.selectPosition(story.nextPositions[index])
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .background(buttonColor),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Transparent,
                            contentColor = textColor
                        )
                    ) {
                        Box(contentAlignment = Alignment.CenterStart) {
                            Text(
                                text = choiceText,
                                color = textColor,
                                fontFamily = FontFamily.Monospace,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start
                            )
                        }
                    }
                }
            }
        }
    }
}
