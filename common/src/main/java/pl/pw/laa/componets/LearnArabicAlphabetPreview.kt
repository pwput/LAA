package pl.pw.laa.componets

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Composable
fun LearnArabicAlphabetSurfacePreview(darkTheme: Boolean = false, content: @Composable () -> Unit) {
    LearnArabicAlphabetTheme(darkTheme = darkTheme) {
        Surface(color = MaterialTheme.colorScheme.background) {
            content()
        }
    }
}

@Composable
fun LearnArabicAlphabetPreview(darkTheme: Boolean = false, content: @Composable () -> Unit) {
    LearnArabicAlphabetTheme(darkTheme = darkTheme) {
            content()
    }
}