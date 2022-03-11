package io.henrikhorbovyi.data.di

import io.henrikhorbovyi.data.common.ServiceBuilder
import io.henrikhorbovyi.data.movie.local.AppDatabase
import io.henrikhorbovyi.data.movie.local.MovieDao
import io.henrikhorbovyi.data.movie.remote.MovieService
import io.henrikhorbovyi.data.movie.repository.MoviesRepository
import io.henrikhorbovyi.data.movie.repository.RealMoviesRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<AppDatabase> { AppDatabase.getInstance(androidContext()) }
    single<MovieDao> { get<AppDatabase>().movieDao() }
    factory {
        ServiceBuilder<MovieService>(baseUrl = "https://imdb-api.com/", "k_d58focsd")
    }
    factory<MoviesRepository> {
        RealMoviesRepository(movieService = get(), movieDao = get())
    }
}