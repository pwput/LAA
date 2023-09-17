package pl.pw.buildsrc

object BuildVersion {
    const val major: Int = 0
    const val minor: Int = 1
    const val patch: Int = 0

    fun getVersionName(): String = "$major.$minor.$patch"
}