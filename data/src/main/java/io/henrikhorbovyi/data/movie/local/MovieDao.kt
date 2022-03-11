package io.henrikhorbovyi.data.movie.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.henrikhorbovyi.data.movie.entity.MoviePreviewLocal

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(vararg movie: MoviePreviewLocal)

    @Query("select * from movie")
    suspend fun fetchAll(): List<MoviePreviewLocal>
}
