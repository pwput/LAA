package pl.pw.laa.presentation.alphabet.components.cell

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.pw.laa.componets.AudioIcon
import pl.pw.laa.componets.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.data.Alphabet

@Composable
fun AlphabetTableContentCellRowName(
    name: String,
    isAudioIconVisible: Boolean = false,
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
        AudioIcon(
            visible = isAudioIconVisible,
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.BottomStart)
        )
    }
}

//region Previews
@Preview
@Composable
fun AlphabetTableContentCellRowNamePreview() {
    LearnArabicAlphabetSurfacePreview {
        AlphabetTableContentCellRowName(
            Alphabet.letters[1].name,
            false,
        )
    }
}

@Preview
@Composable
fun AlphabetTableContentCellRowNameIconPreview() {
    LearnArabicAlphabetSurfacePreview {
        AlphabetTableContentCellRowName(
            Alphabet.letters[1].name,
            true,
        )
    }
}

@Preview
@Composable
fun AlphabetTableContentCellRowNamePreviewDark() {
    LearnArabicAlphabetSurfacePreview(true) {
        AlphabetTableContentCellRowName(
            Alphabet.letters[1].name,
            false,
        )
    }
}
@Preview
@Composable
fun AlphabetTableContentCellRowNameIconPreviewDark() {
    LearnArabicAlphabetSurfacePreview(true) {
        AlphabetTableContentCellRowName(
            Alphabet.letters[1].name,
            true,
        )
    }
}
//endregion