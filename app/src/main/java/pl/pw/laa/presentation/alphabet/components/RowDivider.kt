package pl.pw.laa.presentation.alphabet.components

import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun RowDivider() {
    Divider(color = MaterialTheme.colorScheme.secondary, thickness = 1.dp)
}
