package com.andreisingeleytsev.footballgame.ui.screens.match_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.footballgame.R
import com.andreisingeleytsev.footballgame.ui.theme.MainColor

@Composable
fun MatchScreen(paddingValues: PaddingValues, navHostController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MainColor), contentAlignment = Alignment.Center){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Last matches", style = TextStyle(
                fontSize = 14.sp, color = Color.White
            ))
            Image(
                painter = painterResource(id = R.drawable.last_matches),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        }

    }
}