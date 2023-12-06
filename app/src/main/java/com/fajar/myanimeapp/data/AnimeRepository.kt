package com.fajar.myanimeapp.data

import com.fajar.myanimeapp.model.Anime
import com.fajar.myanimeapp.model.AnimeDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class AnimeRepository {
    private val anime = mutableListOf<Anime>()

    init {
        if(anime.isEmpty()){
            AnimeDataSource.ListAnime.forEach{
                anime.add(Anime(it.id, it.image, it.title, it.synopsis, it.score))
            }
        }
    }

    fun getAllAnime(): Flow<List<Anime>>{
        return flowOf(anime)
    }

    fun getAnimeById(animeId: Long): Anime{
        return anime.first{
            it.id == animeId
        }
    }

    companion object{
        @Volatile
        private var instance: AnimeRepository? = null

        fun getInstance(): AnimeRepository =
            instance ?: synchronized(this){
                AnimeRepository().apply {
                    instance = this
                }
            }
    }
}