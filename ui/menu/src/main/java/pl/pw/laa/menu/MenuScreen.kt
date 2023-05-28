package pl.pw.laa.menu


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import pl.pw.laa.Orientation
import pl.pw.laa.menu.components.MenuButton
import pl.pw.laa.menu.domain.MenuItem
import pl.pw.laa.menu.domain.menuItemsForPreview
import pl.pw.laa.annotation.preview.PreviewsLandscape
import pl.pw.laa.annotation.preview.PreviewsPortrait
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme


interface MenuNavigator{
    fun navigateToQuiz()
    fun navigateToAlphabetTable()
    fun navigateToSettings()
}


@RootNavGraph
@Destination
@Composable
fun MenuScreen(
    navigator: MenuNavigator,
    viewModel: MenuViewModel = hiltViewModel(),
) {
    if (Orientation.isLandscape()) {
        MenuScreenLandscape(viewModel.list, navigator)
    } else {
        MenuScreenPortrait(viewModel.list, navigator)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MenuScreenLandscape(list: List<MenuItem>, navigator: MenuNavigator) {
    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(64.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            list.forEach {
                MenuButton(
                    onClick = { it.navigateToDestination(navigator) },
                    content = it.name,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(16.dp),
                )
            }
        }
    }
}

@Composable
fun MenuScreenPortrait(list: List<MenuItem>, navigator: MenuNavigator) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(64.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        list.forEach {
            MenuButton(
                onClick = { it.navigateToDestination(navigator) },
                content = it.name,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@PreviewsPortrait
@Composable
fun MenuScreenPortraitPreview() {
    LearnArabicAlphabetTheme() {
        //MenuScreenPortrait(menuItemsForPreview, { })
    }
}

@PreviewsLandscape
@Composable
fun MenuScreenLandscapePreview() {
    LearnArabicAlphabetTheme() {
       // MenuScreenLandscape(menuItemsForPreview, EmptyDestinationsNavigator)
    }
}
