package com.fajar.myanimeapp.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fajar.myanimeapp.R

@Composable
fun ProfileScreen(
    onBackClick: () -> Unit,
) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .padding(16.dp)
                .clickable { onBackClick() }
        )
        Box(

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.onepiece),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(80.dp))

                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "Fajar Ramadhan",
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "Fr99704@gmail.com",
                    fontSize = 24.sp
                )
            }
        }
    }
}