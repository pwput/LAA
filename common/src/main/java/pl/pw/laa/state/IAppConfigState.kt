package pl.pw.laa.state

interface IAppConfigState {
    var areCheatsOn: Boolean
    var numberOfAnswers: Int
    var areTipsOn: Boolean
    var isInitialTested: Boolean
    var isMedialTested: Boolean
    var isFinalTested: Boolean
    var isIsolatedTested: Boolean
}