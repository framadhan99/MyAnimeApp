package com.fajar.myanimeapp.ui.navigation


sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Detail : Screen("home/{animeId}") {
        fun createRoute(animeId: Long) = "home/$animeId"
    }
}
