package io.henrikhorbovyi.moviesapp.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import io.henrikhorbovyi.moviesapp.ui.theme.AppTheme

@Composable
fun HeaderText(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 32.sp,
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.titleLarge
            .copy(
                fontSize = fontSize,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
    )
}


@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HeaderTextDarkPreview() {
    AppTheme {
        HeaderText("Hello")
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun HeaderTextLightPreview() {
    AppTheme {
        HeaderText("Hello")
    }
}