package pl.pw.laa.common.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
fun AdmobBanner(modifier: Modifier = Modifier) {
	val isInEditMode = LocalInspectionMode.current
	if (isInEditMode) {
		Box(
				modifier = modifier
						.size(320.dp, 50.dp)
						.background(Color.Red)
		) {
			Text(
					modifier = modifier.align(Alignment.Center),
					textAlign = TextAlign.Center,
					color = Color.White,
					text = "Advert Here",
					style = MaterialTheme.typography.bodyMedium
			)
		}
	} else {
		AndroidView(
				modifier = modifier.fillMaxWidth(),
				factory = { context ->
					AdView(context).apply {
						setAdSize(AdSize.BANNER)
						adUnitId = "ca-app-pub-3940256099942544/6300978111"
						loadAd(AdRequest.Builder().build())
					}
				}
		)
	}
}