package com.fajar.myanimeapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fajar.myanimeapp.ui.navigation.Screen
import com.fajar.myanimeapp.ui.screen.detail.DetailAnimeScreen
import com.fajar.myanimeapp.ui.screen.detail.HomeAnimeScreen
import com.fajar.myanimeapp.ui.screen.profile.ProfileScreen
import com.fajar.myanimeapp.ui.theme.MyAnimeAppTheme
import com.fajar.myanimeapp.ui.screen.profile.ProfileScreen as ProfileScreen1

@Composable
fun MyAnimeApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = {
            MyTopBar(onClick = {
                navController.navigate(Screen.Profile.route)
            })
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.route) {
                HomeAnimeScreen(
                    navigateToDetail = { animeId ->
                        navController.navigate(Screen.Detail.createRoute(animeId))
                    }
                )
            }

            composable(Screen.Profile.route) {
                ProfileScreen (
                    onBackClick = { navController.navigateUp() }
                )
            }

            composable(
                route = Screen.Detail.route,
                arguments = listOf(navArgument("animeId") { type = NavType.LongType }),
            ) {
                val id = it.arguments?.getLong("animeId") ?: -1L
                DetailAnimeScreen(
                    animeId = id,
                    navigateBack = {
                        navController.navigateUp()
                    },

                    )
            }
        }


    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(onClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "My Anime App")
        },
        actions = {
            IconButton(onClick = onClick) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun MyAnimePreview() {
    MyAnimeAppTheme {
        MyAnimeApp()
    }
}