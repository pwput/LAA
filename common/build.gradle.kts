import pl.pw.buildsrc.Dependencies

plugins {
    `module-precompiled`
}

dependencies {
    // project
    implementation(project(Dependencies.Project.data))
}