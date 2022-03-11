package io.henrikhorbovyi.data.movie.repository

import io.henrikhorbovyi.data.movie.entity.MoviePreviewLocal
import io.henrikhorbovyi.data.movie.entity.MoviePreviewRemote
import io.henrikhorbovyi.data.movie.local.MovieDao
import io.henrikhorbovyi.data.movie.remote.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class RealMoviesRepository(
    private val movieService: MovieService,
    private val movieDao: MovieDao,
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) : MoviesRepository {
    override suspend fun fetchTopMovies(): List<MoviePreviewRemote> {
        return listOf() /*withContext(coroutineContext) {
            movieService.fetchTopMovies().movies
        }*/
    }

    override suspend fun fetchMoviesFeed(searchKey: String?): List<MoviePreviewRemote> {
        return listOf() /*withContext(coroutineContext) {
            movieService.fetchMoviesFeed(searchKey ?: "ComingSoon").movies
        }*/
    }

    override suspend fun addToFavorites(movie: MoviePreviewLocal) {
        /*withContext(coroutineContext) {
            movieDao.save(movie)
        }*/
    }

    override suspend fun fetchFavorites(): List<MoviePreviewLocal> {
        return listOf() /* withContext(coroutineContext) {
            movieDao.fetchAll()
        }*/
    }
}
