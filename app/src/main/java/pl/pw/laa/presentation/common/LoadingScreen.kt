package pl.pw.laa.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.pw.laa.BuildConfig
import pl.pw.laa.R

@Composable
fun LoadingScreen() {
    Surface(Modifier.fillMaxSize().background(MaterialTheme.colors.background)) {
        Image(
            painter = painterResource(id = R.drawable.round_volume_up_24),
            contentDescription = "",
            alignment = Alignment.Center,
            modifier = Modifier
                .padding(40.dp)
                .scale(0.5f),
        )
        androidx.compose.material.Text(
            text = "Version - ${BuildConfig.VERSION_NAME}",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            // modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp),
        )
    }

}
