package pl.pw.laa.componets

import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import pl.pw.laa.common.R
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun LoadingScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
val image = AnimatedImageVector.animatedVectorResource(id = R.drawable.loading_animation)
        //CircularProgressIndicator(Modifier.fillMaxWidth(0.1f), color = MaterialTheme.colorScheme.onBackground)
        Image(
            painter = rememberAnimatedVectorPainter(image, true),
            contentDescription = "Loading Content",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .fillMaxSize(0.5f)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoadingScreenPreview() {
    LearnArabicAlphabetTheme() {
        LoadingScreen()
    }
}
