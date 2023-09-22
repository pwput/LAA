package pl.pw.laa.componets

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState

data class Message(
    val text: String,
    val actionLabel: String? = null,
    val withDismissAction: Boolean = false,
    val duration: SnackbarDuration = SnackbarDuration.Short
)

suspend fun SnackbarHostState.showSnackbar(message: Message){
    this.showSnackbar(message.text,message.actionLabel,message.withDismissAction, message.duration)
}