package io.henrikhorbovyi.moviesapp.di

import io.henrikhorbovyi.moviesapp.viewmodel.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MoviesViewModel(get()) }
}