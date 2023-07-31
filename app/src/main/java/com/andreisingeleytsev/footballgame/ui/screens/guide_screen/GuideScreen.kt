package com.andreisingeleytsev.footballgame.ui.screens.guide_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.footballgame.ui.theme.MainColor
import com.andreisingeleytsev.footballgame.ui.theme.SecondaryColor

@Preview
@Composable
fun GuideScreen(paddingValues: PaddingValues, navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize().background(MainColor), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .padding(20.dp)
                .wrapContentSize()
                .background(SecondaryColor), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "In the app you can not only view the schedule of upcoming matches, but even hold them!\n" +
                        "\n" +
                        "To do this, you need to select a match, set the settings that are convenient for you and go to the game.\n" +
                        "\n" +
                        "In the game you need to score goals to your opponent by moving your game scheme. \n" +
                        "The scheme can move up / down and left / right to the borders of the field and kicking the ball.\n" +
                        "\n" +
                        "You can score or concede a goal if the ball goes beyond the allocated area - your goal.\n" +
                        "\n" +
                        "The first time any of your players touches the ball, the ball slows down a little, on the second touch, if it has not been touched by players of the other team, it speeds up. \n" +
                        "\n" +
                        "All played matches will be recorded in your list, where you can then track the result of the actual match.\n" +
                        "\n" +
                        "Also, you can practice by simply running the game without selecting a match.\n", style = TextStyle(
                            color = Color.White, fontSize = 14.sp
                        ), modifier = Modifier.padding(12.dp)
            )
        }
    }
}