package pl.pw.laa.presentation.alphabet.components.cell

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import pl.pw.laa.R
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme


@Composable
fun CellColumnName(resourceId: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
    ) {
        Text(
            stringResource(id = resourceId),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.BottomCenter),
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}

//region Previews
@Composable
@Preview
fun CellColumnNamePreview() {
    LearnArabicAlphabetTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            CellColumnName(
                resourceId = R.string.alphabet_table_top_row_final
            )
        }
    }

}
//endregion