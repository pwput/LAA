package pl.pw.laa.presentation.audioTest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import pl.pw.laa.presentation.audioTest.components.AnswersBox
import pl.pw.laa.presentation.audioTest.components.AudioTestTopBar
import pl.pw.laa.presentation.common.LoadingScreen
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

val paddingValues = PaddingValues(16.dp, 0.dp, 16.dp, 16.dp)

@Destination
@Composable
fun QuestionScreen(
    navigator: DestinationsNavigator,
    viewModel: AudioTestViewModel = hiltViewModel(),
) {
    if (viewModel.isLoading) {
        LoadingScreen()
    } else {
        Column(
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        ) {
            AudioTestTopBar(viewModel.state, modifier = Modifier.padding(0.dp))
            Column(
                modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                QuestionBox(viewModel.state.rightAnswer, viewModel.showIcon, viewModel::onEvent)
                AnswersBox(viewModel.state, viewModel::onAnswer)
            }
        }
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
