package com.fajar.myanimeapp.model

data class Anime(
    val id: Long,
    val image: Int,
    val title: String,
    val synopsis: String,
    val score: Double,
)