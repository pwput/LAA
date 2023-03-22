package pl.pw.laa.ui.audioTest

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Destination
@Composable
fun QuestionScreen(navigator: DestinationsNavigator) {
    val viewModel = viewModel<AudioTestViewModel>()
    Column(
        modifier = Modifier.padding(16.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        QuestionBox(viewModel.state.rightAnswer!!)
        AnswersBox(audioTestState = viewModel.state, onAnswer = viewModel::onAnswer)
    }
}

@Preview
@Composable
fun QuestionScreenPreview() {
    LearnArabicAlphabetTheme {
        Surface() {
            QuestionScreen(navigator = EmptyDestinationsNavigator)
        }
    }
}
