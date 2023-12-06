package com.fajar.myanimeapp.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fajar.myanimeapp.data.AnimeRepository
import com.fajar.myanimeapp.model.Anime
import com.fajar.myanimeapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel (
    private val repository: AnimeRepository
) : ViewModel(){
    private val _uiState: MutableStateFlow<UiState<List<Anime>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Anime>>>
        get() = _uiState

    fun getAllAnime(){
        viewModelScope.launch {
            repository.getAllAnime()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect{anime ->
                    _uiState.value = UiState.Success(anime)

                }
        }
    }
}