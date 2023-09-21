package pl.pw.buildsrc

object BuildVersion {
    private const val major: Int = 0
    private const val minor: Int = 1
    private const val patch: Int = 0

    fun getVersionName(): String = "$major.$minor.$patch"
}