package pl.pw.laa.presentation.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import pl.pw.laa.R

@Composable
fun AudioIcon(modifier: Modifier, visible: Boolean) {
    AnimatedVisibility(
        modifier = modifier,
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut(
            tween(300),
        ),
    ) {
        Icon(
            painter = painterResource(R.drawable.round_volume_up_24),
            contentDescription = "audio icon",
        )
    }
}
