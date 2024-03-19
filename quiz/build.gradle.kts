import pl.pw.buildsrc.Dependencies

plugins {
	id("org.jetbrains.kotlin.android")
	`module-precompiled`
	id("com.google.devtools.ksp") version "1.9.22-1.0.17"
}

dependencies {
	implementation(project(Dependencies.Project.data))
	implementation(project(Dependencies.Project.common))
	implementation(Dependencies.Others.playServicesAds)

	implementation(Dependencies.ComposeDestinations.bottomSheet)
	implementation(Dependencies.ComposeDestinations.core)
	ksp(Dependencies.ComposeDestinations.ksp)
}

ksp {
	arg("compose-destinations.generateNavGraphs", "false")
	arg("compose-destinations.codeGenPackageName", "pl.pw.laa.quiz.generated")
}
