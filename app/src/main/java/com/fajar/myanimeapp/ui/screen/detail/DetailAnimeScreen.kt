package com.fajar.myanimeapp.ui.screen.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fajar.myanimeapp.ui.theme.MyAnimeAppTheme
import com.fajar.myanimeapp.R
import com.fajar.myanimeapp.di.Injection
import com.fajar.myanimeapp.ui.ViewModelFactory
import com.fajar.myanimeapp.ui.common.UiState

@Composable
fun DetailAnimeScreen(
    animeId: Long,
    viewModel: DetailAnimeViewModel = viewModel(
        factory = ViewModelFactory(Injection.providerRepository())
    ),
    navigateBack: () -> Unit,

    ) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAnimeById(animeId)
            }

            is UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    image = data.image,
                    title = data.title,
                    score = data.score,
                    synopsis = data.synopsis,
                    onBackClick = navigateBack,
                )
            }

            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailContent(
    @DrawableRes image: Int,
    title: String,
    score: Double,
    synopsis: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {

        Box {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .height(400.dp)
                    .fillMaxWidth()
                   
            )
            Icon(
                imageVector = Icons.Default.ArrowBack,
                tint = Color.White,
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { onBackClick() }
            )
        }
        Spacer(modifier=Modifier.size(16.dp))
        Text(
            text = title,
            fontSize = 24.sp
        )
        Spacer(modifier=Modifier.size(16.dp))
        Text(
            text = "Score :" + score.toString(),
            fontSize = 16.sp
        )
        Text(
            text = synopsis,
            fontSize = 16.sp
        )
    }
}


