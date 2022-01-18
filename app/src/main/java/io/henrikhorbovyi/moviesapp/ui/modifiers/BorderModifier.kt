package io.henrikhorbovyi.moviesapp.ui.modifiers

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

fun Modifier.bottomBorder(width: Dp, color: Color = Color.Black): Modifier {
    return drawBehind {
        val y = size.height + width.toPx() / 2
        drawLine(
            color,
            Offset(0f, y),
            Offset(size.width, y),
            width.toPx()
        )
    }
}