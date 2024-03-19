package pl.pw.laa.menu.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import pl.pw.laa.common.preview.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.data.Alphabet
import pl.pw.laa.data.domain.Form
import pl.pw.laa.data.domain.Form.Final
import pl.pw.laa.data.domain.Form.Initial
import pl.pw.laa.data.domain.Form.Isolated
import pl.pw.laa.data.domain.Form.Medial
import pl.pw.laa.data.domain.Letter

private val forms = listOf(
		Isolated::class.java,
		Final::class.java,
		Medial::class.java,
		Initial::class.java
)

@Composable
fun LetterExample(letter: Letter) {
	Column(horizontalAlignment = Alignment.CenterHorizontally) {
		Text(text = letter.name, style = MaterialTheme.typography.bodyMedium)
		Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
			forms.forEach { form ->
				FormWithName(form = letter.getForm(form))
			}
		}
	}
}

@Composable
private fun FormWithName(form: Form) {
	Column(horizontalAlignment = Alignment.CenterHorizontally) {
		Text(
				text = form.toString(),
				style = MaterialTheme.typography.bodyLarge,
				textAlign = TextAlign.Justify,
				color = MaterialTheme.colorScheme.onSurface
		)
		Text(
				text = stringResource(id = form.nameResId),
				style = MaterialTheme.typography.bodyMedium,
				color = MaterialTheme.colorScheme.onSurface
		)
	}
}

//region Previews
@Preview
@Composable
fun HomeScreenContentPreview() {
	LearnArabicAlphabetSurfacePreview {
		LetterExample(Alphabet.letters[0])
	}
}

@Preview
@Composable
fun HomeScreenContentPreviewDark() {
	LearnArabicAlphabetSurfacePreview(true) {
		LetterExample(Alphabet.letters[0])
	}
}
//endregion