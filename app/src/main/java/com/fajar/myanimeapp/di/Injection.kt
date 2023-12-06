package com.fajar.myanimeapp.di

import com.fajar.myanimeapp.data.AnimeRepository

object Injection {
    fun providerRepository(): AnimeRepository{
        return AnimeRepository.getInstance()
    }
}