package pl.pw.laa.presentation.menu

import DevicePreviewsDarkLandscape
import DevicePreviewsDarkPortrait
import DevicePreviewsLightLandscape
import DevicePreviewsLightPortrait
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
import pl.pw.laa.presentation.common.Orientation
import pl.pw.laa.presentation.menu.components.MenuButton
import pl.pw.laa.presentation.menu.domain.MenuItem
import pl.pw.laa.presentation.menu.domain.menuItemsForPreview
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@RootNavGraph(start = true)
@Destination
@Composable
fun MenuScreen(
    navigator: DestinationsNavigator,
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
fun MenuScreenLandscape(list: List<MenuItem>, navigator: DestinationsNavigator) {
    Box(
        modifier = Modifier.fillMaxSize(1f).background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(64.dp),
            // horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            list.forEach {
                MenuButton(
                    onClick = { it.navigateToDestination(navigator) },
                    content = it.name,
                    modifier = Modifier.fillMaxWidth(0.5f).padding(16.dp),
                )
            }
        }
    }
}

@Composable
fun MenuScreenPortrait(list: List<MenuItem>, navigator: DestinationsNavigator) {
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

@DevicePreviewsLightPortrait
@DevicePreviewsDarkPortrait
@Composable
fun MenuScreenPortraitPreview() {
    LearnArabicAlphabetTheme() {
        MenuScreenPortrait(menuItemsForPreview, EmptyDestinationsNavigator)
    }
}

@DevicePreviewsLightLandscape
@DevicePreviewsDarkLandscape
@Composable
fun MenuScreenLandscapePreview() {
    LearnArabicAlphabetTheme() {
        MenuScreenLandscape(menuItemsForPreview, EmptyDestinationsNavigator)
    }
}
