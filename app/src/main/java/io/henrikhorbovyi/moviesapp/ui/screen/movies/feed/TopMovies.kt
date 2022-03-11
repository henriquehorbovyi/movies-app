package io.henrikhorbovyi.moviesapp.ui.screen.movies.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import io.henrikhorbovyi.moviesapp.R
import io.henrikhorbovyi.moviesapp.entity.MoviePreview
import io.henrikhorbovyi.moviesapp.ui.components.HeaderText
import io.henrikhorbovyi.moviesapp.ui.components.Rating
import io.henrikhorbovyi.moviesapp.viewmodel.MoviesViewModel

@Composable
fun TopMovies(
    modifier: Modifier = Modifier,
    moviesViewModel: MoviesViewModel,
    onMovieClicked: (MoviePreview) -> Unit = {},
    onLikeClicked: (MoviePreview) -> Unit = {}
) {
    val topMoviesState = moviesViewModel.topMoviesState

    Column(
        modifier = modifier
            .fillMaxWidth()
            .requiredHeightIn(min = 500.dp, max = 1000.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        HeaderText(
            modifier = Modifier.align(Alignment.Start),
            text = "Top Movies",
            fontSize = 22.sp
        )
        LazyColumn(Modifier.fillMaxWidth()) {
            items(3) {
                MovieItem(onClicked = onMovieClicked, onLikeClicked = onLikeClicked)
            }
            item {
                Text(
                    text = "the end \uD83D\uDC7B",
                    color = MaterialTheme.colorScheme.outline,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 64.dp)
                )
            }
        }
        /*topMoviesState.Unbox(
            onLoading = {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            },
            onResult = { movies ->
                if (movies.isEmpty()) {
                    EmptyState(
                        onRetry = { moviesViewModel.fetchTopMovies() },
                        content = {
                            Text(
                                text = "No movies to see!",
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    )
                } else {
                    LazyColumn(Modifier.fillMaxWidth()) {
                        items(3) {
                            MovieItem(onClicked = onMovieClicked, onLikeClicked = onLikeClicked)
                        }
                        item {
                            Text(
                                text = "the end \uD83D\uDC7B",
                                color = MaterialTheme.colorScheme.outline,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 64.dp)
                            )
                        }
                    }
                }
            },
            onError = { errorMessage ->
                EmptyState(
                    icon = {
                        Icon(
                            painterResource(id = R.drawable.ic_warning),
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(38.dp),
                            contentDescription = ""
                        )
                    },
                    onRetry = { moviesViewModel.fetchTopMovies() },
                    content = {
                        Text(
                            text = errorMessage,
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                    }
                )
            }
        )*/
    }
}

@Composable
private fun MovieItem(
    movie: MoviePreview = MoviePreview(
        "123",
        "miranha",
        image = "https://amc-theatres-res.cloudinary.com/image/upload/f_auto,fl_lossy,h_465,q_auto,w_310/v1638549265/amc-cdn/production/2/movies/66500/66520/PosterDynamic/132670.jpg"
    ),
    onClicked: (MoviePreview) -> Unit = {},
    onLikeClicked: (MoviePreview) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .height(142.dp)
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = { onClicked(movie) }),
        backgroundColor = MaterialTheme.colorScheme.surface
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberImagePainter(movie.image),
                contentDescription = null,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MovieInfo(movie)
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_favorite),
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(28.dp)
                        .clip(CircleShape)
                        .clickable {
                            onLikeClicked(movie)
                           // movie = movie.copy(isLiked = !movie.isLiked)
                        },

                    contentDescription = "save to favorites button"
                )
            }
        }

    }
}

@Composable
private fun MovieInfo(movie: MoviePreview) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = movie.title,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Rating(starCount = movie.stars)
        Text(
            text = "Year ${movie.year}",
            style = MaterialTheme.typography.labelSmall
        )
    }
}
