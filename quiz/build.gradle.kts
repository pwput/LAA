import pl.pw.buildsrc.Dependencies

plugins {
    id("org.jetbrains.kotlin.android")
    `module-precompiled`
    id("com.google.devtools.ksp") version "1.8.0-1.0.9"
}

ksp {
    arg("compose-destinations.mode", "destinations")
    arg("compose-destinations.moduleName", "quiz")
}

dependencies {
    implementation(project(Dependencies.Project.data))
    implementation(project(Dependencies.Project.common))

    // material
    implementation(pl.pw.buildsrc.Dependencies.Androidx.Compose.material3)
    // compose
    implementation(pl.pw.buildsrc.Dependencies.Androidx.Compose.ui)
    implementation(pl.pw.buildsrc.Dependencies.Androidx.Compose.materialIconsExtended)
    implementation(pl.pw.buildsrc.Dependencies.Androidx.Compose.foundation)
    implementation(pl.pw.buildsrc.Dependencies.Androidx.Compose.foundationLayout)
    implementation(pl.pw.buildsrc.Dependencies.Androidx.Compose.animation)
    implementation(pl.pw.buildsrc.Dependencies.Androidx.Compose.runtime)
    implementation(pl.pw.buildsrc.Dependencies.Androidx.Compose.runtimeLivedata)
    implementation(pl.pw.buildsrc.Dependencies.Androidx.Compose.uiTooling)

    // androidx
    implementation(pl.pw.buildsrc.Dependencies.Androidx.startup)
    implementation(pl.pw.buildsrc.Dependencies.Androidx.navigationCompose)
    implementation(pl.pw.buildsrc.Dependencies.Androidx.constraintlayoutCompose)
    implementation(pl.pw.buildsrc.Dependencies.Androidx.activityCompose)
    implementation(pl.pw.buildsrc.Dependencies.Androidx.hiltNavigationCompose)
    implementation(pl.pw.buildsrc.Dependencies.Androidx.lifecycleRuntimeCompose)
    implementation(pl.pw.buildsrc.Dependencies.Androidx.splashscreen)

    // hilt
    implementation(pl.pw.buildsrc.Dependencies.Dagger.hilt)
    kapt(pl.pw.buildsrc.Dependencies.Dagger.hiltCompiler)
    // coroutines
    implementation(pl.pw.buildsrc.Dependencies.Kotlinx.Coroutines.android)
    // timber log
    implementation(Dependencies.Others.timber)
    // compose directions
    implementation(pl.pw.buildsrc.Dependencies.ComposeDestinations.animationsCore)
    ksp(pl.pw.buildsrc.Dependencies.ComposeDestinations.ksp)
    //compose state events
    implementation(Dependencies.Others.composeStateEvents)
}