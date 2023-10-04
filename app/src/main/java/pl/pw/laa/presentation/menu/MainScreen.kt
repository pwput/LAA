package pl.pw.laa.presentation.menu


import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import pl.pw.laa.Orientation
import pl.pw.laa.annotation.preview.PreviewsLandscape
import pl.pw.laa.annotation.preview.PreviewsPortrait
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@RootNavGraph(start = true)
@Destination
@Composable
fun MainScreen(
    navigator: DestinationsNavigator,
    padding: PaddingValues,
    viewModel: MenuViewModel = hiltViewModel(),
) {
    Surface(modifier = Modifier.padding(padding)) {
        MainScreenContent()
    }
}

@Composable
fun MainScreenContent() {
    Text(text = "MainScreenContent")
}

@PreviewsPortrait
@Composable
fun MenuScreenPortraitPreview() {
    LearnArabicAlphabetTheme() {
        MainScreenContent()
    }
}

@PreviewsLandscape
@Composable
fun MenuScreenLandscapePreview() {
    LearnArabicAlphabetTheme() {
        MainScreenContent()
    }
}
