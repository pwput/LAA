package pl.pw.laa.componets

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState

data class CustomSnackbarData(
    val text: String,
    val actionLabel: String? = null,
    val showIcon: Boolean = false,
    val duration: SnackbarDuration = SnackbarDuration.Short
)

suspend fun SnackbarHostState.showSnackbar(customSnackbarData: CustomSnackbarData){
    this.showSnackbar(customSnackbarData.text,customSnackbarData.actionLabel,customSnackbarData.showIcon, customSnackbarData.duration)
}