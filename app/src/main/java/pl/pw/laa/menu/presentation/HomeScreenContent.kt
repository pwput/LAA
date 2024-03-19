package pl.pw.laa.menu.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.laa.R
import pl.pw.laa.common.componets.AdmobBanner
import pl.pw.laa.common.componets.CardBox
import pl.pw.laa.common.preview.LearnArabicAlphabetScreenContentPreview
import pl.pw.laa.data.Alphabet
import pl.pw.laa.menu.presentation.components.LetterExample
import pl.pw.laa.menu.state.HomeState

@Composable
fun HomeScreenContent(
		homeState: HomeState
) {
	val containersColor = MaterialTheme.colorScheme.secondaryContainer

	Box(modifier = Modifier.fillMaxSize()) {
		Column(
				modifier = Modifier
						.padding(16.dp)
						.fillMaxSize()
						.align(Alignment.Center),
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally
		) {
			CardBox(
					cardModifier = Modifier.padding(bottom = 16.dp),
					colors = CardDefaults.cardColors(containerColor = containersColor),
					elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
			) {
				HomeScreenContentTextColumn()
			}
			CardBox(
					boxModifier = Modifier.padding(16.dp),
					colors = CardDefaults.cardColors(containerColor = containersColor),
					elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
			) {
				LetterExample(letter = Alphabet.letters[homeState.letterId])
			}
		}
		AdmobBanner(
				Modifier
						.align(Alignment.BottomCenter)
						.padding(bottom = 4.dp)
		)
	}
}

@Composable
private fun HomeScreenContentTextColumn() {
	Column(
			modifier = Modifier
					.padding(16.dp),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
	) {
		HomeScreenContentText(R.string.home_screen_content_right_to_left)
		HomeScreenContentText(R.string.home_screen_content_basic_letters)
		HomeScreenContentText(R.string.home_screen_content_example)
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