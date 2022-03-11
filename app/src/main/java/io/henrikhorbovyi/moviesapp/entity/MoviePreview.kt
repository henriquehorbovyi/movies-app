package io.henrikhorbovyi.moviesapp.entity

import io.henrikhorbovyi.data.movie.entity.MoviePreviewRemote

data class MoviePreview(
    val id: String,
    val title: String,
    val image: String = "",
    val rating: String = "",
    val year: String = "",
    val stars: Int = (5 * (rating.toDoubleOrNull() ?: 0.0).toInt()) / 10,
    var isLiked: Boolean = false
)

fun MoviePreviewRemote.toUi(): MoviePreview {
    return MoviePreview(
        id = id,
        title = title,
        image = image,
        year = year,
        rating = imDbRating
    )
}