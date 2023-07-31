package com.andrei_singeleytsev.sportquizapp.presentation.navigation


import android.media.MediaPlayer
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.andreisingeleytsev.footballgame.ui.screens.game_screen.game.GameScreen
import com.andreisingeleytsev.footballgame.ui.screens.guide_screen.GuideScreen
import com.andreisingeleytsev.footballgame.ui.screens.match_screen.MatchScreen
import com.andreisingeleytsev.footballgame.ui.screens.settings_screen.SettingsScreen
import com.andreisingeleytsev.footballgame.ui.utils.Routes


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainNavigationGraph(navController: NavHostController, paddingValues: PaddingValues, mediaPlayer: MediaPlayer?) {

    NavHost(navController = navController, startDestination = Routes.COMPARISON_SCREEN) {

        composable(Routes.COMPARISON_SCREEN){
            EnterAnimation {
                MatchScreen(paddingValues, navController)
            }


        }
        composable(Routes.GAME_SCREEN){
            EnterAnimation {
                GameScreen(paddingValues, navController)
            }

        }
        composable(Routes.GUIDE_SCREEN){
            EnterAnimation {
                GuideScreen(paddingValues, navController)
            }
        }
        composable(Routes.SETTINGS_SCREEN){
            EnterAnimation {
                SettingsScreen(paddingValues, navController, mediaPlayer)
            }
        }

        }
    }
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun EnterAnimation(content: @Composable () -> Unit) {
    AnimatedVisibility(
        visible = true,
        enter = slideInVertically(
            initialOffsetY = { -40 }
        ) + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutVertically() + shrinkVertically() + fadeOut(),
        content = content,
        initiallyVisible = false
    )
}