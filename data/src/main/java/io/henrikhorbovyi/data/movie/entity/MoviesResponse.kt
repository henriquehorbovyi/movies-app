package io.henrikhorbovyi.data.movie.entity

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("items")
    val movies: List<MoviePreviewRemote>,

    @SerializedName("errorMessage")
    val errorMessage: String,
)
