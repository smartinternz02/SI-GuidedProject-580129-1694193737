package com.yt.fooddeliveryappui.screens.bottomNavigation

import com.yt.fooddeliveryappui.R


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
) {


    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.home_tab,
        icon_focused = R.drawable.home_tab
    )

}