package com.andreisingeleytsev.footballgame.ui.menu

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.andreisingeleytsev.footballgame.ui.theme.MainColor


@Composable
fun FootballBottomNavigationMenu(currentRoute: String?, onNavigate: (String)->Unit) {
    val listItems = listOf(
        BottomNavigationItem.ComparisonItem,
        BottomNavigationItem.GameItem,
        BottomNavigationItem.GuideItem,
        BottomNavigationItem.SettingsItem
    )
    BottomAppBar(
        containerColor = MainColor
    ) {
        listItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute==item.route,
                onClick = {
                          onNavigate(item.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon_id),
                        contentDescription = "bottom_icon"
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Green,
                    unselectedIconColor = Color.White,
                    indicatorColor = MainColor
                )
            )

        }
    }
}