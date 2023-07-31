package com.andreisingeleytsev.footballgame.ui.screens.game_screen.game

import android.view.MotionEvent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.andreisingeleytsev.footballgame.R
import com.andreisingeleytsev.footballgame.ui.theme.MainColor

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun GameScreen(paddingValues: PaddingValues, navHostController: NavHostController, viewModel: GameScreenViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MainColor),
        contentAlignment = Alignment.Center
    ) {
        if (viewModel.isGameOn.value) Box(
            modifier = Modifier
                .width(268.75.dp)
                .height(430.dp), contentAlignment = Alignment.Center
        ) {
            val density = LocalContext.current.resources.displayMetrics.density
            viewModel.density = density
            Image(
                painter = painterResource(id = R.drawable.football_field),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
            Image(
                painter = painterResource(id = R.drawable.ball),
                contentDescription = null,
                modifier = Modifier
                    .size(14.dp)
                    .offset(viewModel.ballOffset.value.first, viewModel.ballOffset.value.second)
            )
            Image(
                painter = painterResource(id = R.drawable.red_ball),
                contentDescription = null,
                modifier = Modifier
                    .size(17.dp)
                    .offset(
                        x = viewModel.listRed[0].value.first,
                        y = viewModel.listRed[0].value.second
                    )
                    .pointerInteropFilter { event ->
                        when (event.action) {
                            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {

                                viewModel.onEvent(
                                    GameScreenEvent.OnRotateChange(
                                        event.x,
                                        event.y,
                                        Pair(false, 0)
                                    )
                                )
                                true
                            }

                            MotionEvent.ACTION_UP -> {
                                viewModel.onEvent(GameScreenEvent.OnPushTheBall)
                                true
                            }

                            else -> false
                        }
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.red_ball),
                contentDescription = null,
                modifier = Modifier
                    .size(17.dp)
                    .offset(
                        x = viewModel.listRed[1].value.first,
                        y = viewModel.listRed[1].value.second
                    )
                    .pointerInteropFilter { event ->
                        when (event.action) {
                            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {

                                viewModel.onEvent(
                                    GameScreenEvent.OnRotateChange(
                                        event.x,
                                        event.y,
                                        Pair(false, 1)
                                    )
                                )
                                true
                            }

                            MotionEvent.ACTION_UP -> {
                                viewModel.onEvent(GameScreenEvent.OnPushTheBall)
                                true
                            }

                            else -> false
                        }
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.red_ball),
                contentDescription = null,
                modifier = Modifier
                    .size(17.dp)
                    .offset(
                        x = viewModel.listRed[2].value.first,
                        y = viewModel.listRed[2].value.second
                    )
                    .pointerInteropFilter { event ->
                        when (event.action) {
                            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {

                                viewModel.onEvent(
                                    GameScreenEvent.OnRotateChange(
                                        event.x,
                                        event.y,
                                        Pair(false, 2)
                                    )
                                )
                                true
                            }

                            MotionEvent.ACTION_UP -> {
                                viewModel.onEvent(GameScreenEvent.OnPushTheBall)
                                true
                            }

                            else -> false
                        }
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.red_ball),
                contentDescription = null,
                modifier = Modifier
                    .size(17.dp)
                    .offset(
                        x = viewModel.listRed[3].value.first,
                        y = viewModel.listRed[3].value.second
                    )
                    .pointerInteropFilter { event ->
                        when (event.action) {
                            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {

                                viewModel.onEvent(
                                    GameScreenEvent.OnRotateChange(
                                        event.x,
                                        event.y,
                                        Pair(false, 3)
                                    )
                                )
                                true
                            }

                            MotionEvent.ACTION_UP -> {
                                viewModel.onEvent(GameScreenEvent.OnPushTheBall)
                                true
                            }

                            else -> false
                        }
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.blue_ball),
                contentDescription = null,
                modifier = Modifier
                    .size(17.dp)
                    .offset(
                        x = viewModel.listBlue[0].value.first,
                        y = viewModel.listBlue[0].value.second
                    )
                    .pointerInteropFilter { event ->
                        when (event.action) {
                            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {

                                viewModel.onEvent(
                                    GameScreenEvent.OnRotateChange(
                                        event.x,
                                        event.y,
                                        Pair(true, 0)
                                    )
                                )
                                true
                            }

                            MotionEvent.ACTION_UP -> {
                                viewModel.onEvent(GameScreenEvent.OnPushTheBall)
                                true
                            }

                            else -> false
                        }
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.blue_ball),
                contentDescription = null,
                modifier = Modifier
                    .size(17.dp)
                    .offset(
                        x = viewModel.listBlue[1].value.first,
                        y = viewModel.listBlue[1].value.second
                    )
                    .pointerInteropFilter { event ->
                        when (event.action) {
                            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                                viewModel.onEvent(
                                    GameScreenEvent.OnRotateChange(
                                        event.x,
                                        event.y,
                                        Pair(true, 1)
                                    )
                                )
                                true
                            }

                            MotionEvent.ACTION_UP -> {
                                viewModel.onEvent(GameScreenEvent.OnPushTheBall)
                                true
                            }

                            else -> false
                        }
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.blue_ball),
                contentDescription = null,
                modifier = Modifier
                    .size(17.dp)
                    .offset(
                        x = viewModel.listBlue[2].value.first,
                        y = viewModel.listBlue[2].value.second
                    )
                    .pointerInteropFilter { event ->
                        when (event.action) {
                            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {

                                viewModel.onEvent(
                                    GameScreenEvent.OnRotateChange(
                                        event.x,
                                        event.y,
                                        Pair(true, 2)
                                    )
                                )
                                true
                            }

                            MotionEvent.ACTION_UP -> {
                                viewModel.onEvent(GameScreenEvent.OnPushTheBall)
                                true
                            }

                            else -> false
                        }
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.blue_ball),
                contentDescription = null,
                modifier = Modifier
                    .size(17.dp)
                    .offset(
                        x = viewModel.listBlue[3].value.first,
                        y = viewModel.listBlue[3].value.second
                    )
                    .pointerInteropFilter { event ->
                        when (event.action) {
                            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {

                                viewModel.onEvent(
                                    GameScreenEvent.OnRotateChange(
                                        event.x,
                                        event.y,
                                        Pair(true, 3)
                                    )
                                )
                                true
                            }

                            MotionEvent.ACTION_UP -> {
                                viewModel.onEvent(GameScreenEvent.OnPushTheBall)
                                true
                            }

                            else -> false
                        }
                    }
            )
        }
        else Text(
            text = if (!viewModel.currentChip.first) "Red"+ " wins"
            else "Blue"+ " wins", style = TextStyle(color = Color.White, fontSize = 30.sp)
        )
    }
}