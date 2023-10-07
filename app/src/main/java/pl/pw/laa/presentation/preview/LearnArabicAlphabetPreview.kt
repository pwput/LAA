package pl.pw.laa.presentation.preview

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Composable
fun LearnArabicAlphabetSurfacePreview(darkTheme: Boolean = false, content: @Composable () -> Unit) {
    LearnArabicAlphabetTheme(darkTheme = darkTheme) {
        Surface(color = MaterialTheme.colorScheme.background) {
            content.invoke()
        }
    }
}
