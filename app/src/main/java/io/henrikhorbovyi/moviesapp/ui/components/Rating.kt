package io.henrikhorbovyi.moviesapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import io.henrikhorbovyi.moviesapp.R

@Composable
fun Rating(
    starCount: Int = 0,
    starAmount: Int = 5
) {
    Row {
        repeat(starAmount) {
            val iconId = if (it >= starCount)
                R.drawable.ic_star_outline
            else
                R.drawable.ic_star
            Icon(
                painter = painterResource(id = iconId),
                tint = Color(0xddfb972d),
                contentDescription = ""
            )
        }
    }
}

@Preview
@Composable
fun RatingPreview() {
    Rating(starCount = 3)
}