package io.henrikhorbovyi.moviesapp.ui.screen.movies.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import io.henrikhorbovyi.moviesapp.R
import io.henrikhorbovyi.moviesapp.entity.MoviePreview
import io.henrikhorbovyi.moviesapp.state.Unbox
import io.henrikhorbovyi.moviesapp.ui.components.EmptyState
import io.henrikhorbovyi.moviesapp.viewmodel.MoviesViewModel

@Composable
fun MoviesFeed(
    modifier: Modifier = Modifier,
    moviesViewModel: MoviesViewModel,
    searchKey: String,
    onMovieClicked: (MoviePreview?) -> Unit = {}
) {

    val moviesFeedState = moviesViewModel.moviesFeedState
    LaunchedEffect(searchKey) {
        moviesViewModel.fetchMoviesFeed(searchKey)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(340.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        moviesFeedState.Unbox(
            onLoading = {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            },
            onResult = { movies ->
                MoviesContent(
                    movies,
                    onMovieClicked = onMovieClicked,
                    onRetry = { moviesViewModel.fetchMoviesFeed(searchKey) }
                )
            },
            onError = { errorMessage ->
                ErrorHandler(
                    errorMessage = errorMessage,
                    onRetry = { moviesViewModel.fetchMoviesFeed(searchKey) }
                )
            }
        )
    }
}

@Composable
private fun MoviesContent(
    movies: List<MoviePreview>,
    onMovieClicked: (MoviePreview?) -> Unit,
    onRetry: () -> Unit = {}
) {
    if (movies.isEmpty()) {
        EmptyState(
            onRetry = onRetry,
            content = {
                Text(
                    text = "No movies to see!",
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        )
    } else {
        LazyRow {
            item { Spacer(Modifier.width(10.dp)) }
            items(movies) {
                MovieItem(
                    movie = it,
                    onClicked = onMovieClicked
                )
            }
            item { Spacer(Modifier.width(10.dp)) }
        }
    }
}

@Composable
private fun MovieItem(
    modifier: Modifier = Modifier,
    movie: MoviePreview,
    onClicked: (MoviePreview) -> Unit = {}
) {
    Card(
        modifier = modifier
            .padding(horizontal = 10.dp)
            .size(220.dp, 340.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClicked(movie) },
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp,
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = rememberImagePainter(movie.image),
            contentScale = ContentScale.Crop,
            contentDescription = ""
        )
    }
}

@Composable
private fun ErrorHandler(
    errorMessage: String,
    onRetry: () -> Unit
) {
    EmptyState(
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_warning),
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(38.dp),
                contentDescription = "Warning icon"
            )
        },
        onRetry = onRetry,
        content = {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    )
}
