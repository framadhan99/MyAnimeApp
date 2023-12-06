package com.fajar.myanimeapp.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fajar.myanimeapp.model.AnimeDataSource
import com.fajar.myanimeapp.ui.components.AnimeItem

@Composable
fun HomeScreen(
    modifier : Modifier,
    navigateToDetail: (Long) -> Unit,
){
    Box(modifier = modifier) {
        LazyColumn(

        ) {
            items(AnimeDataSource.ListAnime, key = { it.id }) { anime ->
                AnimeItem(image = anime.image, title = anime.title, score = anime.score)
            }
        }
    }
}