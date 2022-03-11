package io.henrikhorbovyi.moviesapp.ui.screen.movies.details

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Details(
    modifier: Modifier = Modifier,
    movieId: String? = "",
) {
    Column(
        modifier = modifier
    ) {
        Text(text = "Details of $movieId")
    }
}

@Preview(showSystemUi = true)
@Composable
fun DetailsPreview() {
    Details()
}