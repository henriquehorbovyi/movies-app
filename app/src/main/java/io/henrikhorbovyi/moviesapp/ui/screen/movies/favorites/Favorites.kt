package io.henrikhorbovyi.moviesapp.ui.screen.movies.favorites

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.GridItemSpan
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.henrikhorbovyi.moviesapp.R
import io.henrikhorbovyi.moviesapp.entity.MoviePreview
import io.henrikhorbovyi.moviesapp.ui.components.HeaderText

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Favorites(
    modifier: Modifier = Modifier,
    /*moviesViewModel: MoviesViewModel,*/
    onMovieSelected: (id: String) -> Unit = {}
) {
        LazyVerticalGrid(
            modifier = modifier,
            cells = GridCells.Fixed(2),
            content = {
                item(
                    span = { GridItemSpan(2) },
                    content = {
                        HeaderText(
                            text = "Favorite Movies",
                            Modifier.padding(vertical = 16.dp, horizontal = 24.dp)
                        )
                    }
                )

                items(5) {
                    FavoriteMovieItem(onMovieSelected = onMovieSelected)
                }
            }
        )
}

@Composable
fun FavoriteMovieItem(movie: MoviePreview? = null, onMovieSelected: (String) -> Unit = {}) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable { onMovieSelected(movie?.id ?: "123") }
            .wrapContentSize(unbounded = false)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.spiderman),
            contentScale = ContentScale.FillWidth,
            contentDescription = ""
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun FavoritesPreview() {
    Favorites()
}
