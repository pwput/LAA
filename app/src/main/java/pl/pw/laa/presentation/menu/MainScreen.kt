package pl.pw.laa.presentation.menu

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import pl.pw.laa.componets.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.data.Alphabet
import pl.pw.laa.R
import pl.pw.laa.data.domain.Form
import pl.pw.laa.data.domain.Form.*
import pl.pw.laa.data.domain.Letter

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
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainScreenContentText(R.string.main_screen_content_right_to_left)
        MainScreenContentText(R.string.main_screen_content_basic_letters)
        MainScreenContentText(R.string.main_screen_content_example)
        MainScreenContentLetterExample(letter = Alphabet.letters[4])
    }
}

@Composable
private fun MainScreenContentText(textId: Int) {
    Text(
        text = stringResource(id = textId),
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Justify,
        color = MaterialTheme.colorScheme.onSurface
    )
}

private val forms = listOf(
    Isolated::class.java,
    Final::class.java,
    Medial::class.java,
    Initial::class.java
)

@Composable
fun MainScreenContentLetterExample(letter: Letter) {
    Text(text = letter.name, style = MaterialTheme.typography.bodyMedium)

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        forms.forEach { form ->
            MainScreenContentFormWithName(form = letter.getForm(form))
        }
    }
}

@Composable
private fun MainScreenContentFormWithName(form: Form) {
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

@Preview(showSystemUi = true)
@Composable
fun MainScreenContentPreview() {
    LearnArabicAlphabetSurfacePreview {
        MainScreenContent()
    }
}

