package io.henrikhorbovyi.moviesapp.state

import androidx.compose.runtime.Stable

@Stable
interface UiState<T> {
    val data: T
    val isLoading: Boolean
    var errorMessage: String?
    val hasError: Boolean
        get() = errorMessage != null
}