package com.fajar.myanimeapp.ui.screen.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fajar.myanimeapp.di.Injection
import com.fajar.myanimeapp.model.Anime
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
    onClick: () -> Unit,

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
                    onClick = onClick
                )
            }
            is UiState.Error -> {}

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    anime: List<Anime>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
    onClick: () -> Unit,
) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "My Anime App")
                },
                actions = {
                    IconButton(onClick = onClick) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "about_page"
                        )
                    }
                }
            )
        }
    ){paddingValue->
        LazyVerticalGrid(
            modifier = modifier.padding(paddingValue),
            columns = GridCells.Adaptive(160.dp),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
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
}


