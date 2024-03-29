package pl.pw.laa.alphabet.presentation.components.cell

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.pw.laa.common.preview.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.data.Alphabet
import pl.pw.laa.data.domain.Form

@Composable
fun CellForm(form: Form, modifier: Modifier = Modifier) {
	Box(
			modifier = modifier,
	) {
		Text(
				text = form.char.toString(),
				style = MaterialTheme.typography.bodyLarge,
				modifier = Modifier.align(Alignment.Center),
				color = MaterialTheme.colorScheme.onBackground,
		)
	}
}

////region Previews
@Preview
@Composable
fun CellFormPreview() {
	LearnArabicAlphabetSurfacePreview {
		CellForm(Alphabet.letters[1].final)
	}
}

@Preview
@Composable
fun CellFormPreviewDark() {
	LearnArabicAlphabetSurfacePreview(true) {
		CellForm(Alphabet.letters[1].final)
	}
}
//endregion