package pl.pw.laa.presentation.common.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Composable
fun LoadingScreen() {
    Box(
        Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(Modifier.fillMaxWidth(0.1f), color = MaterialTheme.colorScheme.onBackground)
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoadingScreenPreview() {
    LearnArabicAlphabetTheme() {
        LoadingScreen()
    }
}
