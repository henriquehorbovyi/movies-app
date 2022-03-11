package io.henrikhorbovyi.data.movie.remote

import io.henrikhorbovyi.data.movie.entity.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("API/Top250Movies/")
    suspend fun fetchTopMovies(): MoviesResponse

    @GET("API/{searchKey}/")
    suspend fun fetchMoviesFeed(
        @Path("searchKey") searchKey: String
    ): MoviesResponse
}