package pl.pw.laa.common.componets

import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun RowDivider() {
	Divider(color = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp), thickness = 1.dp)
}
