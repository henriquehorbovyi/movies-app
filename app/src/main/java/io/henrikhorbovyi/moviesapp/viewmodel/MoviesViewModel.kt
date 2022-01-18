package io.henrikhorbovyi.moviesapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import io.henrikhorbovyi.moviesapp.state.MoviesUiState

class MoviesViewModel(
    // private val moviesRepository: MoviesRepository
) : ViewModel() {
    var moviesUiState by mutableStateOf(MoviesUiState())
        private set

    fun fetchMovies() {
        moviesUiState = MoviesUiState(movies = listOf())
    }
}
