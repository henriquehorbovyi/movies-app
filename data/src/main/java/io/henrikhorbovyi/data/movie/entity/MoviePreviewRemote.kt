package io.henrikhorbovyi.data.movie.entity

import com.google.gson.annotations.SerializedName

data class MoviePreviewRemote(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("imDbRating")
    val imDbRating: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("year")
    val year: String
)

fun MoviePreviewRemote.toLocal(): MoviePreviewLocal {
    return MoviePreviewLocal(
        id = id,
        title = title,
        imDbRating = imDbRating,
        image = image,
        year = year
    )
}