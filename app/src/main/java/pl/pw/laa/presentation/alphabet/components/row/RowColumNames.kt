package pl.pw.laa.presentation.alphabet.components.row

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.pw.laa.R
import pl.pw.laa.presentation.preview.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.presentation.alphabet.components.cell.CellColumnName



@Composable
fun RowColumNames(modifier: Modifier = Modifier, tagsModifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        CellColumnName(
            resourceId = R.string.alphabet_table_top_row_name,
            modifier = tagsModifier
                .weight(1f)
                .background(MaterialTheme.colorScheme.background),
        )
        CellColumnName(
            resourceId = R.string.alphabet_table_top_row_isolated,
            modifier = tagsModifier
                .weight(1f)
                .background(MaterialTheme.colorScheme.background),
        )
        CellColumnName(
            resourceId = R.string.alphabet_table_top_row_final,
            modifier = tagsModifier
                .weight(1f)
                .background(MaterialTheme.colorScheme.background),
        )
        CellColumnName(
            resourceId = R.string.alphabet_table_top_row_medial,
            modifier = tagsModifier
                .weight(1f)
                .background(MaterialTheme.colorScheme.background),
        )
        CellColumnName(
            resourceId = R.string.alphabet_table_top_row_initial,
            modifier = tagsModifier
                .weight(1f)
                .background(MaterialTheme.colorScheme.background),
        )
    }
}

//region Previews
@Preview
@Composable
fun RowColumNamesPreview() {
    LearnArabicAlphabetSurfacePreview {
        RowColumNames()
    }
}

@Preview
@Composable
fun RowColumNamesPreviewDark() {
    LearnArabicAlphabetSurfacePreview(true) {
        RowColumNames()
    }
}
//endregion