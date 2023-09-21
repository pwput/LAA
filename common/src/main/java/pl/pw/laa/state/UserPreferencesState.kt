package pl.pw.laa.state

interface UserPreferencesState {
    var answersCount: Int
    var areCheatsEnabled: Boolean
    var areTipsEnabled: Boolean
    var isInitialTested: Boolean
    var isMedialTested: Boolean
    var isFinalTested: Boolean
    var isIsolatedTested: Boolean
}