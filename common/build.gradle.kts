import pl.pw.buildsrc.Dependencies

plugins {
    id("org.jetbrains.kotlin.android")
    `module-precompiled`
}

dependencies {
    // project
    implementation(project(Dependencies.Project.data))
    implementation(Dependencies.Others.playServicesAds)

}