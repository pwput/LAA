package pl.pw.laa.common.componets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import pl.pw.laa.common.R

@Composable
fun AudioIcon(visible: Boolean) {
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
				contentScale = ContentScale.FillHeight,
		)
	}
}

//region Previews
//@Preview
//@Composable
//fun AudioIconPreview() {
//    LearnArabicAlphabetSurfacePreview {
//        AudioIcon(true)
//    }
//}