package pl.pw.laa.common.componets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

@Composable
fun CardBox(
		cardModifier: Modifier = Modifier,
		boxModifier: Modifier = Modifier,
		shape: Shape = CardDefaults.shape,
		colors: CardColors = CardDefaults.cardColors(),
		elevation: CardElevation = CardDefaults.cardElevation(),
		border: BorderStroke? = null,
		contentAlignment: Alignment = Alignment.Center,
		content: @Composable (BoxScope.() -> Unit)
) {
	Card(
			shape = shape,
			border = border,
			elevation = elevation,
			colors = colors,
			modifier = cardModifier
	) {
		Box(contentAlignment = contentAlignment, modifier = boxModifier.fillMaxWidth()) {
			content.invoke(this)
		}
	}
}
