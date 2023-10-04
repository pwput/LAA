package pl.pw.buildsrc.extensions

import pl.pw.buildsrc.Dependencies
import org.gradle.api.artifacts.dsl.DependencyHandler

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
