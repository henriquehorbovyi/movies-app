package io.henrikhorbovyi.moviesapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import io.henrikhorbovyi.data.movie.repository.MoviesRepository
import io.henrikhorbovyi.moviesapp.state.MoviesFeedUiState
import io.henrikhorbovyi.moviesapp.state.TopMoviesUiState

class MoviesViewModel(
    private val moviesRepository: MoviesRepository
) : ViewModel() {
    var topMoviesState by mutableStateOf(TopMoviesUiState())
        private set

    var moviesFeedState by mutableStateOf(MoviesFeedUiState())
        private set

    init {
        fetchTopMovies()
    }

    fun fetchTopMovies() {
        /*viewModelScope.launch {
            topMoviesState = topMoviesState.copy(
                isLoading = true,
                errorMessage = null,
                data = emptyList()
            )
            topMoviesState = try {
                val movies = moviesRepository.fetchTopMovies().map { it.toUi() }


                topMoviesState.copy(data = movies, isLoading = false)
            } catch (e: Exception) {
                topMoviesState.copy(
                    errorMessage = "Something went wrong!",
                    isLoading = false,
                    data = emptyList()
                )
            }
        }*/
    }

    fun fetchMoviesFeed(searchKey: String? = null) {
        /*viewModelScope.launch {
            moviesFeedState = moviesFeedState.copy(
                isLoading =  true,
                errorMessage = null,
                data = emptyList()
            )

            moviesFeedState = try {
                val movies = moviesRepository
                    .fetchMoviesFeed(searchKey)
                    .map { it.toUi() }
                moviesFeedState.copy(data = movies, isLoading = false)
            } catch (e: Exception) {
                moviesFeedState.copy(
                    errorMessage = "Something went wrong!",
                    isLoading = false,
                    data = emptyList()
                )
            }
        }*/
    }
}
