package io.henrikhorbovyi.moviesapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.henrikhorbovyi.moviesapp.R
import io.henrikhorbovyi.moviesapp.entity.Movie
import io.henrikhorbovyi.moviesapp.ui.components.FeedTabRow
import io.henrikhorbovyi.moviesapp.ui.components.TabItem


@Composable
fun MoviesScreen() {
    var moviesFeedSearchKeyState by remember { mutableStateOf(TabItem.News.searchKey) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Films",
            modifier = Modifier.padding(start = 24.dp, top = 24.dp, bottom = 16.dp),
            style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold)
        )
        FeedTabRow(
            modifier = Modifier.padding(horizontal = 16.dp),
            onTabSelected = { item -> moviesFeedSearchKeyState = item.searchKey }
        )
        MoviesFeed(
            modifier = Modifier.padding(top = 16.dp),
            searchKey = moviesFeedSearchKeyState
        )
        // AllMovies()
    }
}

@Composable
fun MoviesFeed(
    modifier: Modifier = Modifier,
    searchKey: String,
    onMovieClicked: (Movie?) -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        LazyRow {
            item { Spacer(Modifier.width(10.dp)) }
            items(3) {
                MoviesFeedItem(
                    movie = null,
                    onClicked = onMovieClicked
                )
            }
            item { Spacer(Modifier.width(10.dp)) }
        }
    }
}

@Composable
fun MoviesFeedItem(
    movie: Movie?,
    modifier: Modifier = Modifier,
    onClicked: (Movie?) -> Unit = {}
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
            painter = painterResource(id = R.drawable.spiderman),
            contentScale = ContentScale.Crop,
            contentDescription = "Movie"
        )
    }
}

@Composable
fun AllMovies() {
    TODO()
}

@Preview(showSystemUi = true)
@Composable
fun MoviesScreenPreview() {
    MoviesScreen()
}