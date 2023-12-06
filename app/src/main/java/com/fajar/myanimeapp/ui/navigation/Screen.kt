package com.fajar.myanimeapp.ui.navigation

sealed class Screen(val route: String){
    object Home: Screen("home")
    object Profile: Screen("profile")
    object Detail: Screen("detail") {
        fun createRoute(animeId: Long) = "home/$animeId"
    }
}
