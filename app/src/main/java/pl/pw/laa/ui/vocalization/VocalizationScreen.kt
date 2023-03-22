package pl.pw.laa.ui.vocalization

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Destination
@Composable
fun VocalizationScreen(navigator: DestinationsNavigator) {
    Text(text = "vocalization")
}

@Preview
@Composable
fun VocalizationScreenPreview() {
    LearnArabicAlphabetTheme(dynamicColor = false) {
        Surface(modifier = Modifier.fillMaxSize()) {
            VocalizationScreen(navigator = EmptyDestinationsNavigator)
        }
    }
}
