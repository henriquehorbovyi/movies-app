package io.henrikhorbovyi.data.movie.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MoviePreviewLocal(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val title: String,
    val imDbRating: String,
    val image: String,
    val year: String,
    val isLiked: Boolean = false
)
