package io.henrikhorbovyi.data.movie.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.henrikhorbovyi.data.movie.entity.MoviePreviewLocal

@Database(
    entities = [MoviePreviewLocal::class],
    exportSchema = false,
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room
                .databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app-database"
                )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}