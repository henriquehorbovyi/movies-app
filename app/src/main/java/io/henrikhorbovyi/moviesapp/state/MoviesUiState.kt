package io.henrikhorbovyi.moviesapp.state

import io.henrikhorbovyi.moviesapp.entity.Movie

data class MoviesUiState(
    val movies: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
