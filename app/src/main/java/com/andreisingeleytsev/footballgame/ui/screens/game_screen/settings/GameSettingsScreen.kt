package com.andreisingeleytsev.footballgame.ui.screens.game_screen.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreisingeleytsev.footballgame.R
import com.andreisingeleytsev.footballgame.ui.theme.MainColor

@Composable
fun GameSettingsScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(MainColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.game_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Text(text = "Choose a team:")
        Row(Modifier.padding(start = 50.dp, end = 50.dp)) {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.red),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
                Text(
                    text = "RED", style = TextStyle(

                    )
                )
            }
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.blue),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
                Text(text = "BLUE", style = TextStyle(

                ))
            }
        }
        Button(
            onClick = {

            }, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            )
        ) {
            Text(
                text = "Play", style = TextStyle(
                    color = Color.White, fontSize = 14.sp
                )
            )
        }
    }
}