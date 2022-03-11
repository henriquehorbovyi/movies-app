package io.henrikhorbovyi.moviesapp.ui.screen.movies.feed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.henrikhorbovyi.moviesapp.ui.modifiers.bottomBorder

sealed class TabItem(val title: String, val searchKey: String) {
    object News : TabItem(title = "News", searchKey = "ComingSoon")
    object Popular : TabItem(title = "Popular", searchKey = "MostPopularMovies")
    object ShowingNow : TabItem(title = "Showing Now", searchKey = "InTheaters")
}

@Composable
fun FeedTabRow(
    modifier: Modifier = Modifier,
    onTabSelected: (TabItem) -> Unit
) {
    var selectedTab: TabItem by remember { mutableStateOf(TabItem.News) }
    val tabs = listOf(TabItem.News, TabItem.Popular, TabItem.ShowingNow)

    Row(modifier = modifier) {
        tabs.forEach { tab ->
            FeedTab(
                text = tab.title,
                isSelected = selectedTab == tab,
                onSelect = {
                    selectedTab = tab // UI
                    onTabSelected(tab) // callback
                },
            )
        }
    }
}

@Composable
fun FeedTab(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean = false,
    onSelect: () -> Unit,
) {
    val borderColor = if (isSelected)
        MaterialTheme.colorScheme.primary
    else
        Color.Transparent

    val textColor = if (isSelected)
        MaterialTheme.colorScheme.primary
    else
        MaterialTheme.colorScheme.outline

    Column(
        modifier = modifier
            .padding(end = 10.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onSelect)
    ) {
        Text(
            modifier = Modifier
                .padding(all = 10.dp)
                .align(CenterHorizontally)
                .bottomBorder(width = 3.dp, borderColor),
            text = text,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.ExtraBold,
                color = textColor
            )
        )
    }
}
