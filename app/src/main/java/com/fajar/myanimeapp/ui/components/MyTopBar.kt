package com.fajar.myanimeapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(
    onClick: () -> Unit,
) {
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