package com.fajar.myanimeapp.ui.screen.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fajar.myanimeapp.ui.theme.MyAnimeAppTheme
import com.fajar.myanimeapp.R
import com.fajar.myanimeapp.di.Injection
import com.fajar.myanimeapp.model.Anime
import com.fajar.myanimeapp.model.AnimeDataSource
import com.fajar.myanimeapp.ui.ViewModelFactory
import com.fajar.myanimeapp.ui.common.UiState
import com.fajar.myanimeapp.ui.components.AnimeItem
import com.fajar.myanimeapp.ui.screen.home.HomeViewModel

@Composable
fun HomeAnimeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.providerRepository())
    ),
    navigateToDetail: (Long) -> Unit,

    ) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllAnime()
            }

            is UiState.Success -> {
                HomeContent(
                    anime = uiState.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail,
                )
            }
            is UiState.Error -> {}

        }
    }
}

@Composable
fun HomeContent(
    anime: List<Anime>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit
) {
    LazyColumn(
    modifier = modifier
    ) {
        items(anime) { data ->
            AnimeItem(
                image = data.image,
                title = data.title,
                score = data.score,
                modifier = Modifier.clickable {
                    navigateToDetail(data.id)

                }.padding(bottom = 8.dp)
            )
        }
    }
}


