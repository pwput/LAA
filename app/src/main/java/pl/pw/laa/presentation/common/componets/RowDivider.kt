package pl.pw.laa.presentation.common.componets

import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun RowDivider() {
    Divider(color = MaterialTheme.colorScheme.secondary, thickness = 1.dp)
}
