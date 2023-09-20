package pl.pw.laa.data.domain

data class UserPreferences(
    val answersCount: Int,
    val areCheatsEnabled: Boolean,
    val areTipsEnabled: Boolean,
    val isInitial: Boolean,
    val isMedial: Boolean,
    val isFinal: Boolean,
    val isIsolated: Boolean
)