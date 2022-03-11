package io.henrikhorbovyi.moviesapp.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import io.henrikhorbovyi.moviesapp.R
import io.henrikhorbovyi.moviesapp.ui.screen.movies.details.Details
import io.henrikhorbovyi.moviesapp.ui.screen.movies.favorites.Favorites
import io.henrikhorbovyi.moviesapp.ui.screen.movies.feed.Movies
import io.henrikhorbovyi.moviesapp.viewmodel.MoviesViewModel
import kotlin.properties.Delegates

enum class MainGraph(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: String
) {
    Feed(R.string.feed, R.drawable.ic_movies, "main/feed"),
    Favorites(R.string.favorites, R.drawable.ic_favorite, "main/favorites"),
}

fun NavGraphBuilder.mainGraph(
    moviesViewModel: MoviesViewModel,
    onMovieSelected: (id: String?) -> Unit = {}
) {
    navigation(startDestination = MainGraph.Feed.route, route = "main") {
        composable(MainGraph.Feed.route) {
            Movies(
                moviesViewModel = moviesViewModel,
                onMovieSelected = onMovieSelected,
                modifier = Modifier.padding(bottom = 32.dp),
            )
        }
        composable(MainGraph.Favorites.route) {
            Favorites(
                /*moviesViewModel = moviesViewModel,*/
                onMovieSelected = onMovieSelected,
                modifier = Modifier.padding(bottom = 80.dp)
            )
        }
    }
    composable(
        route = "details/{movieId}",
        arguments = listOf(navArgument("movieId") { type = NavType.StringType })
    ) { backStackEntry ->
        val movieId = backStackEntry.arguments?.getString("movieId")
        Details(movieId = movieId)
    }
}
