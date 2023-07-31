package com.andreisingeleytsev.footballgame.ui.menu

import com.andreisingeleytsev.footballgame.R
import com.andreisingeleytsev.footballgame.ui.utils.Routes

sealed class BottomNavigationItem( val icon_id: Int, val route: String) {
    object ComparisonItem: BottomNavigationItem( R.drawable.comparision, Routes.COMPARISON_SCREEN)
    object GameItem: BottomNavigationItem( R.drawable.game, Routes.GAME_SCREEN)
    object GuideItem: BottomNavigationItem( R.drawable.guide, Routes.GUIDE_SCREEN)
    object SettingsItem: BottomNavigationItem( R.drawable.settings, Routes.SETTINGS_SCREEN)
}
