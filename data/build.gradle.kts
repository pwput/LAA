plugins {
    id("org.jetbrains.kotlin.android")
    `module-precompiled`
}

dependencies{
    // Room
    implementation(pl.pw.buildsrc.Dependencies.Androidx.Room.runtime)
    annotationProcessor(pl.pw.buildsrc.Dependencies.Androidx.Room.compiler)
    kapt(pl.pw.buildsrc.Dependencies.Androidx.Room.compiler)
    implementation(pl.pw.buildsrc.Dependencies.Androidx.Room.ktx)
}