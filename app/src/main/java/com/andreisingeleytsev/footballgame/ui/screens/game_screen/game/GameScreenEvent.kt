package com.andreisingeleytsev.footballgame.ui.screens.game_screen.game

sealed class GameScreenEvent{
    data class OnRotateChange(val x: Float , val y: Float, val chip: Pair<Boolean, Int>): GameScreenEvent()
    object OnPushTheBall: GameScreenEvent()
}
