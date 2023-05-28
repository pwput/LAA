import pl.pw.buildsrc.Dependencies
plugins {
    `module-precompiled`
}
android{
    ksp {
        arg("compose-destinations.mode", "destinations")
        arg("compose-destinations.moduleName", name)
    }
}

dependencies {
    // project
    implementation(project(Dependencies.Project.data))
    implementation(project(Dependencies.Project.common))

    // compose directions
    implementation(Dependencies.ComposeDestinations.animationsCore)
    ksp(Dependencies.ComposeDestinations.ksp)
}