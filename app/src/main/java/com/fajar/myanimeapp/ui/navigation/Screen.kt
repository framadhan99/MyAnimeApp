package com.fajar.myanimeapp.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object AnimeDetail : Screen("home/{id}") {
        fun createRoute(id: Long) = "home/$id"
    }
}
