package pl.pw.buildsrc.extensions

import org.gradle.api.artifacts.dsl.DependencyHandler
import pl.pw.buildsrc.Dependencies

fun DependencyHandler.implementation(list: List<String>) {
	list.forEach { dependency ->
		add("implementation", dependency)
	}
}

fun DependencyHandler.kapt(list: List<String>) {
	list.forEach { dependency ->
		add("kapt", dependency)
	}
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
	list.forEach { dependency ->
		add("androidTestImplementation", dependency)
	}
}

fun DependencyHandler.testImplementation(list: List<String>) {
	list.forEach { dependency ->
		add("testImplementation", dependency)
	}
}

fun DependencyHandler.implementRoom() {
	add("implementation", Dependencies.Androidx.Room.runtime)
	add("annotationProcessor", Dependencies.Androidx.Room.compiler)
	add("kapt", Dependencies.Androidx.Room.compiler)
	add("implementation", Dependencies.Androidx.Room.ktx)
}
