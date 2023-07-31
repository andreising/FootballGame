package com.andreisingeleytsev.footballgame.ui.screens.game_screen.game

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.sportgameapp.ui.utils.FootballUIEvents
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class GameScreenViewModel: ViewModel() {
    private val _uiEvent = Channel<FootballUIEvents>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: GameScreenEvent){
        when(event) {
            is GameScreenEvent.OnRotateChange -> {
                currentChip = event.chip
                val thisChip = if (currentChip.first) listBlue[currentChip.second]
                else listRed[currentChip.second]
                changeAngle(
                    (event.x.dp / density).value,
                    (event.y.dp / density).value,
                )
            }

            is GameScreenEvent.OnPushTheBall -> {
                chipTimer.start()
            }
        }
    }
    private fun sendUIEvent(event: FootballUIEvents){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
    val listBlue = listOf(
        mutableStateOf(
            Pair(0.dp, 40.dp)
        ),
        mutableStateOf(
            Pair(-60.dp, 80.dp)
        ),
        mutableStateOf(
            Pair(60.dp, 80.dp)
        ),
        mutableStateOf(
            Pair(0.dp, 120.dp)
        )
    )
    val listRed = listOf(
        mutableStateOf(
            Pair(0.dp, -40.dp)
        ),
        mutableStateOf(
            Pair(-60.dp, -80.dp)
        ),
        mutableStateOf(
            Pair(60.dp, -80.dp)
        ),
        mutableStateOf(
            Pair(0.dp, -120.dp)
        )
    )
    val ballOffset = mutableStateOf(
        Pair(0.dp, 0.dp)
    )
    var density = 0f
    var defaultSpeed = 20
    val rotate = mutableStateOf(0f)
    val ballRotate = mutableStateOf(0f)
    private fun changeAngle(x: Float, y: Float) {
        val angle = atan2(x, y)
        val floatAngle = angle*(180F / PI).toFloat()
        rotate.value = floatAngle
    }

    var currentChip = Pair(false, 0)

    private val chipTimer = object : CountDownTimer(10000, 30){
        override fun onTick(p0: Long) {
            val radians = Math.toRadians(rotate.value.toDouble())
            checkRicochete()
            if (currentChip.first) {
                val first = listBlue[currentChip.second].value.first+sin(radians) * defaultSpeed.dp
                val second = listBlue[currentChip.second].value.second+cos(radians) * defaultSpeed.dp
                listBlue[currentChip.second].value = Pair(first, second)
            } else {
                val first = listRed[currentChip.second].value.first+sin(radians) * defaultSpeed.dp
                val second = listRed[currentChip.second].value.second+cos(radians) * defaultSpeed.dp
                listRed[currentChip.second].value = Pair(first, second)
            }

            defaultSpeed--
            if (defaultSpeed==0) {
                defaultSpeed=20
                isMove = false
                ballTimer.cancel()
                cancel()
            }
        }

        override fun onFinish() {

        }

    }
    var isMove = false
    private val ballTimer = object : CountDownTimer(10000, 30){
        override fun onTick(p0: Long) {
            val radians = Math.toRadians(ballRotate.value.toDouble())
            checkBallRicochete()
            val x = ballOffset.value.first + sin(radians) * defaultSpeed.dp
            val y = ballOffset.value.second + cos(radians) * defaultSpeed.dp
            ballOffset.value = Pair(x, y)



        }
        override fun onFinish() {

        }

    }

    private fun checkRicochete() {
        val radians = Math.toRadians(rotate.value.toDouble())
        val thisChip = if (currentChip.first) listBlue[currentChip.second]
        else listRed[currentChip.second]
        val x = thisChip.value.first+ sin(radians) * defaultSpeed.dp
        val y = thisChip.value.second+cos(radians) * defaultSpeed.dp
        val xBall = (x-ballOffset.value.first).value/density
        val yBall = (y-ballOffset.value.second).value/density
        if (x!in -130.dp..130.dp) {
            rotate.value = -rotate.value
            return
        }
        if (y !in -210.dp..210.dp) {
            rotate.value = -rotate.value - 180F
        }
        val rad =
            sqrt((xBall*xBall) + (yBall*yBall))
        if (rad <= 14.dp.value / density) {
            isMove = true
            ballRotate.value = rotate.value
            ballTimer.start()
        }
    }
    val isGameOn = mutableStateOf(true)
    private fun checkBallRicochete() {
        val radians = Math.toRadians(ballRotate.value.toDouble())
        val x = ballOffset.value.first+ sin(radians) * defaultSpeed.dp
        if (x!in -130.dp..130.dp) {

            ballRotate.value = -ballRotate.value
            return
        }
        val y = ballOffset.value.second+cos(radians) * defaultSpeed.dp
        if (y!in -210.dp..210.dp) {
            ballRotate.value = -ballRotate.value-180F
        }
        if (x in -34.dp..34.dp) {
            if (-167.dp in y-7.dp..y+7.dp) {
                isGameOn.value = false
                ballTimer.cancel()
            }
            if (167.dp in y-7.dp..y+7.dp) {
                isGameOn.value = false
                ballTimer.cancel()
            }
        }
        for (i in listBlue.indices) {
            val chip = listBlue[i]
            val xBall = (chip.value.first-ballOffset.value.first).value/density
            val yBall = (chip.value.second-ballOffset.value.second).value/density
            val rad =
                sqrt((xBall*xBall) + (yBall*yBall))
            if (rad <= 14.dp.value / density) {
                ballRotate.value = -ballRotate.value-180F
            }
        }
        for (i in listRed.indices) {
            val chip = listRed[i]
            val xBall = (chip.value.first-ballOffset.value.first).value/density
            val yBall = (chip.value.second-ballOffset.value.second).value/density
            val rad =
                sqrt((xBall*xBall) + (yBall*yBall))
            if (rad <= 14.dp.value / density) {
                ballRotate.value = -ballRotate.value-180F
            }
        }

    }
}