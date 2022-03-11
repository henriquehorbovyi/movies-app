package io.henrikhorbovyi.moviesapp.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import io.henrikhorbovyi.moviesapp.navigation.MainGraph

@Composable
fun rememberAppState(
    navController: NavController
) = remember(navController) {
    AppState(navController = navController)
}

@Stable
class AppState(
    private val navController: NavController
) {

    val mainBottomBarTabs = MainGraph.values()
    private val mainGraphRoutes = mainBottomBarTabs.map { it.route }

    val shouldShowBottomBar: Boolean
        @Composable get() = navController
            .currentBackStackEntryAsState()
            .value?.destination?.route in mainGraphRoutes

    val currentRoute: String?
        get() = navController.currentDestination?.route
}
