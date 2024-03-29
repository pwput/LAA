plugins {
	`kotlin-dsl`
	`kotlin-dsl-precompiled-script-plugins`
}

repositories {
	google()
	mavenCentral()
	gradlePluginPortal()
	maven { url = uri("https://jitpack.io") }
}

dependencies {
	implementation("com.android.tools.build:gradle:8.1.1")
	implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")
	implementation("com.squareup:javapoet:1.13.0")
}