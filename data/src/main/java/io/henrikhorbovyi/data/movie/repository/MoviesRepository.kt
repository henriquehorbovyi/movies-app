package io.henrikhorbovyi.data.movie.repository

import io.henrikhorbovyi.data.movie.entity.MoviePreviewLocal
import io.henrikhorbovyi.data.movie.entity.MoviePreviewRemote

interface MoviesRepository {
    suspend fun fetchTopMovies(): List<MoviePreviewRemote>
    suspend fun fetchMoviesFeed(searchKey: String?): List<MoviePreviewRemote>
    suspend fun addToFavorites(movie: MoviePreviewLocal)
    suspend fun fetchFavorites(): List<MoviePreviewLocal>
}