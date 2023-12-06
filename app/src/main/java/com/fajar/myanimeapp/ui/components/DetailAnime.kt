package com.fajar.myanimeapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.fajar.myanimeapp.ui.theme.MyAnimeAppTheme
import com.fajar.myanimeapp.R

@Composable
fun DetailAnime(
    image: Int,
    title: String,
    score: Double,
    synopsis: String
) {
    Column {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
        )
        Text(text = title)
        Text(
            text = "Score :" + score.toString(),
            fontSize = 8.sp
        )
        Text(
            text = synopsis,
            fontSize = 8.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DetailAnimePreview() {
    MyAnimeAppTheme {
        DetailAnime(
            image = R.drawable.onepiece,
            title = "One Piece",
            score = 9.3,
            synopsis = "One Piece"
        )
    }
}