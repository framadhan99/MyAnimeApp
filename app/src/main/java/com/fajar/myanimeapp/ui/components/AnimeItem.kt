package com.fajar.myanimeapp.ui.components

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fajar.myanimeapp.R
import com.fajar.myanimeapp.ui.theme.MyAnimeAppTheme
import java.time.format.TextStyle

@Composable
fun AnimeItem(
    image: Int,
    title: String,
    score: Double,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable {}.padding(bottom = 8.dp)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(80.dp)
        )
        Column (
            modifier = Modifier.padding(start = 8.dp, end = 16.dp)
        ){
            Text(
                text = title,
            )
            Text(
                text = "score :" + score.toString(),

                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Light,

                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AnimeItemPreview() {
    MyAnimeAppTheme {
        AnimeItem(image = R.drawable.onepiece, title = "One Piece", score = 9.3)
    }
}