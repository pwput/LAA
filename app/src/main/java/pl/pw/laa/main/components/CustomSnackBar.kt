package pl.pw.laa.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.laa.R
import pl.pw.laa.common.ui.theme.Dimensions
import pl.pw.laa.common.ui.theme.LearnArabicAlphabetTheme

@Composable
fun CustomSnackBar(
		showIcon: Boolean,
		message: String,
) {
	Snackbar(
			modifier = Modifier
					.padding(Dimensions.Padding.medium),
			containerColor = MaterialTheme.colorScheme.secondaryContainer,
			contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
	) {
		Row(
				horizontalArrangement = Arrangement.Center,
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier.wrapContentWidth(),

				) {
			if (showIcon) {
				Icon(
						painter = painterResource(id = R.drawable.round_volume_up_24),
						contentDescription = null,
						tint = MaterialTheme.colorScheme.onSecondaryContainer,
						modifier = Modifier
                                .height(24.dp)
                                .padding(end = Dimensions.Padding.small)
				)
			}
			Text(
					message,
					textAlign = TextAlign.Center,
					style = MaterialTheme.typography.labelMedium
			)
		}
	}
}

@Preview
@Composable
fun CustomSnackBarPreview() {
	LearnArabicAlphabetTheme {
		CustomSnackBar(true, "Test")
	}
}