package com.fajar.myanimeapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.unit.dp
import com.fajar.myanimeapp.model.AnimeDataSource
import com.fajar.myanimeapp.ui.components.AnimeItem
import com.fajar.myanimeapp.ui.theme.MyAnimeAppTheme

@Composable
fun MyAnimeApp() {
    Scaffold (
        topBar = { MyTopBar(onClick ={}) }
    ) {paddingValues ->

        Box(modifier = Modifier.padding(paddingValues)) {
            LazyColumn(

            ) {
                items(AnimeDataSource.ListAnime, key = { it.id }) { anime ->
                    AnimeItem(image = anime.image, title = anime.title, score = anime.score)
                }
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
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Mark as favorite"
                )
            }
        }
    )
}
@Composable
@Preview (showBackground = true)
fun MyAnimePreview(){
    MyAnimeAppTheme {
        MyAnimeApp()
    }
}