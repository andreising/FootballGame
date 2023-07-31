package com.andreisingeleytsev.sportgameapp.ui.utils

sealed class FootballUIEvents(){
    //gdfjgld
    data class OnNavigate(val route: String): FootballUIEvents()
}
