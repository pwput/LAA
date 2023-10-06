package pl.pw.laa.presentation.menu

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.laa.data.Alphabet
import pl.pw.laa.R
import pl.pw.laa.componets.AdmobBanner
import pl.pw.laa.presentation.preview.LearnArabicAlphabetScreenContentPreview
import pl.pw.laa.presentation.menu.components.LetterExample

@Composable
fun HomeScreenContent(
    homeState: HomeState
) {
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomeScreenContentText(R.string.home_screen_content_right_to_left)
            HomeScreenContentText(R.string.home_screen_content_basic_letters)
            HomeScreenContentText(R.string.home_screen_content_example)
            LetterExample(letter = Alphabet.letters[homeState.letterId])
        }
        AdmobBanner(Modifier.align(Alignment.BottomCenter).padding(bottom = 4.dp))
    }
}

@Composable
private fun HomeScreenContentText(textId: Int) {
    Text(
        text = stringResource(id = textId),
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Justify,
        color = MaterialTheme.colorScheme.onSurface
    )
}

//region Previews
@Preview(showSystemUi = true)
@Composable
fun HomeScreenContentPreview() {
    LearnArabicAlphabetScreenContentPreview {
        HomeScreenContent(HomeState(4))
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenContentPreviewDark() {
    LearnArabicAlphabetScreenContentPreview(true) {
        HomeScreenContent(HomeState(4))
    }
}
//endregion