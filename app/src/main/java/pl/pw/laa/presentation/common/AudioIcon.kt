package pl.pw.laa.presentation.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import pl.pw.laa.R

@Composable
fun AudioIcon(visible: Boolean, modifier: Modifier = Modifier) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut(
            tween(300),
        ),
    ) {
        Image(
            painter = painterResource(R.drawable.round_volume_up_24),
            contentDescription = "audio icon",
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onSecondaryContainer),
            modifier = modifier.scale(0.5f),
            contentScale = ContentScale.FillHeight,
        )
    }
}
