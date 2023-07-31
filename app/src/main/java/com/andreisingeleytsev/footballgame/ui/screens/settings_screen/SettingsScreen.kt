package com.andreisingeleytsev.footballgame.ui.screens.settings_screen

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.footballgame.ui.theme.MainColor

@Composable
fun SettingsScreen(paddingValues: PaddingValues, navHostController: NavHostController, mediaPlayer: MediaPlayer?) {
    val sound = remember {
        mutableStateOf(true)
    }
    val blur = remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MainColor), contentAlignment = Alignment.Center){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = "Sound:", style = TextStyle(
                    color = Color.White, fontSize = 14.sp
                ))
                Switch(
                    checked = sound.value, onCheckedChange = {
                        sound.value = !sound.value
                        if (!sound.value) mediaPlayer?.stop()
                    }, colors = SwitchDefaults.colors(
                        uncheckedTrackColor = Color.White,
                        checkedTrackColor = Color.Black,
                        uncheckedThumbColor = MainColor,
                        checkedThumbColor = MainColor
                    )
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Blur:", style = TextStyle(
                    color = Color.White, fontSize = 14.sp
                )
                )
                Switch(
                    checked = blur.value, onCheckedChange = {
                        blur.value = !blur.value
                    }, colors = SwitchDefaults.colors(
                        uncheckedTrackColor = Color.White,
                        checkedTrackColor = Color.Black,
                        uncheckedThumbColor = MainColor,
                        checkedThumbColor = MainColor
                    )
                )
            }
        }
    }
}