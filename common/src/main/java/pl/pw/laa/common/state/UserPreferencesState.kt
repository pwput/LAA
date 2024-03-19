package pl.pw.laa.common.state

data class UserPreferencesState(
		var questionsCount: Int = 0,
		var answersCount: Int = 0,
		var areCheatsEnabled: Boolean = false,
		var areTipsEnabled: Boolean = false,
		var isInitialTested: Boolean = false,
		var isMedialTested: Boolean = false,
		var isFinalTested: Boolean = false,
		var isIsolatedTested: Boolean = false
)