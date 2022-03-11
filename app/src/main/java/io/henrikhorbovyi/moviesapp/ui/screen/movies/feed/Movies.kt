package io.henrikhorbovyi.moviesapp.ui.screen.movies.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.henrikhorbovyi.moviesapp.ui.components.HeaderText
import io.henrikhorbovyi.moviesapp.viewmodel.MoviesViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun Movies(
    modifier: Modifier = Modifier,
    onMovieSelected: (id: String?) -> Unit = {},
    moviesViewModel: MoviesViewModel
) {
    var moviesFeedSearchKeyState by remember { mutableStateOf(TabItem.News.searchKey) }
    val paddingModifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)

    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        HeaderText(
            modifier = paddingModifier,
            text = "Movie+"
        )
        FeedTabRow(
            modifier = Modifier.padding(horizontal = 16.dp),
            onTabSelected = { item -> moviesFeedSearchKeyState = item.searchKey }
        )

        MoviesFeed(
            modifier = Modifier.padding(top = 16.dp),
            moviesViewModel = moviesViewModel,
            searchKey = moviesFeedSearchKeyState,
            onMovieClicked = { onMovieSelected(it?.id) }
        )

        TopMovies(
            modifier = paddingModifier,
            moviesViewModel = moviesViewModel,
            onMovieClicked = { onMovieSelected(it.id) },
            onLikeClicked = {  }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun MoviesScreenPreview() {
    Movies(moviesViewModel = getViewModel())
}