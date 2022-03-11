package io.henrikhorbovyi.moviesapp.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import io.henrikhorbovyi.moviesapp.navigation.MainGraph
import io.henrikhorbovyi.moviesapp.navigation.mainGraph
import io.henrikhorbovyi.moviesapp.state.rememberAppState
import io.henrikhorbovyi.moviesapp.ui.theme.AppTheme
import io.henrikhorbovyi.moviesapp.viewmodel.MoviesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {

    private val moviesViewModel: MoviesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val appState = rememberAppState(navController = navController)

            AppTheme {
                Scaffold(
                    content = {
                        NavHost(
                            navController = navController,
                            startDestination = "main"
                        ) {
                            mainGraph(
                                moviesViewModel = moviesViewModel,
                                onMovieSelected = { id ->
                                    navController.navigate("details/$id")
                                }
                            )
                        }
                    },
                    bottomBar = {
                        if (appState.shouldShowBottomBar) {
                            MainNavigationBar(
                                tabs = appState.mainBottomBarTabs,
                                currentRoute = appState.currentRoute,
                                onNavigate = { route -> navController.navigate(route) }
                            )
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun MainNavigationBar(
    tabs: Array<MainGraph>,
    currentRoute: String?,
    onNavigate: (route: String) -> Unit
) {
    val selectedTab = tabs.first { it.route == currentRoute }

    NavigationBar {
        tabs.forEach { tab ->
            NavigationBarItem(
                selected = tab == selectedTab,
                onClick = { onNavigate(tab.route) },
                label = { Text(text = stringResource(id = tab.title)) },
                icon = {
                    Icon(
                        painter = painterResource(id = tab.icon),
                        contentDescription = "bottom navigation bar ${tab.title} icon"
                    )
                }
            )
        }
    }
}