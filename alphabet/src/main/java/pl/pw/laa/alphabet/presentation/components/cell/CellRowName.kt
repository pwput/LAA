package pl.pw.laa.alphabet.presentation.components.cell

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.pw.laa.common.preview.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.data.Alphabet

@Composable
fun CellRowName(
		name: String,
		modifier: Modifier = Modifier,
) {
	Box(
			modifier = modifier.height(IntrinsicSize.Max)
	) {
		Text(
				text = name,
				style = MaterialTheme.typography.bodyMedium,
				modifier = Modifier.align(Alignment.Center),
				color = MaterialTheme.colorScheme.onBackground,
		)
	}
}

//region Previews
@Preview
@Composable
fun CellRowNamePreview() {
	LearnArabicAlphabetSurfacePreview {
		CellRowName(
				Alphabet.letters[1].name,
		)
	}
}

@Preview
@Composable
fun CellRowNameIconPreview() {
	LearnArabicAlphabetSurfacePreview {
		CellRowName(
				Alphabet.letters[1].name,
		)
	}
}

@Preview
@Composable
fun CellRowNamePreviewDark() {
	LearnArabicAlphabetSurfacePreview(true) {
		CellRowName(
				Alphabet.letters[1].name,
		)
	}
}

@Preview
@Composable
fun CellRowNameIconPreviewDark() {
	LearnArabicAlphabetSurfacePreview(true) {
		CellRowName(
				Alphabet.letters[1].name,
		)
	}
}
//endregion