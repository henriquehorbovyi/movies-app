package io.henrikhorbovyi.moviesapp.state

import io.henrikhorbovyi.moviesapp.entity.MoviePreview

data class MoviesFeedUiState(
    override val data: List<MoviePreview> = emptyList(),
    override val isLoading: Boolean = false,
    override var errorMessage: String? = null
) : UiState<List<MoviePreview>>