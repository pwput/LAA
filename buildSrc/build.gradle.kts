import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies{
    implementation("com.android.tools.build:gradle:8.0.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
    implementation("com.google.devtools.ksp:symbol-processing-api:1.8.10-1.0.9")
    implementation("com.squareup:javapoet:1.13.0")
}