package io.henrikhorbovyi.moviesapp.state

import androidx.compose.runtime.Composable

@Composable
fun <T> UiState<T>.Unbox(
    onLoading: @Composable () -> Unit,
    onResult: @Composable (T) -> Unit,
    onError: @Composable (String) -> Unit,
) {
    if (isLoading)
        onLoading()
    else {
        if (hasError)
            errorMessage?.let { onError(it) }
        else
            onResult(data)
    }
}