import pl.pw.buildsrc.BuildVersion.getVersionName
import pl.pw.buildsrc.Dependencies
import pl.pw.buildsrc.Dependencies.Androidx
import pl.pw.buildsrc.Dependencies.ComposeDestinations
import pl.pw.buildsrc.Dependencies.Dagger
import pl.pw.buildsrc.Dependencies.Kotlinx
import pl.pw.buildsrc.Versions
import pl.pw.buildsrc.extensions.implementRoom
import pl.pw.buildsrc.extensions.implementation

plugins {
	id("com.android.application")
	kotlin("kapt")
	id("org.jetbrains.kotlin.android")
	id("com.google.devtools.ksp") version "1.9.22-1.0.17"
	id("dagger.hilt.android.plugin")
}

android {
	namespace = "pl.pw.laa"
	compileSdk = 34
	defaultConfig {
		applicationId = "pl.pw.laa"
		minSdk = 24
		versionCode = 1
		versionName = getVersionName()

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}

	buildTypes {
		release {
			//minifyEnabled =false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}
	kotlinOptions {
		jvmTarget = "17"
	}
	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = Versions.kotlinCompiler
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
	applicationVariants.all {
		kotlin.sourceSets {
			getByName(name) {
				kotlin.srcDir("build/generated/ksp/$name/kotlin")
			}
		}
	}
}
dependencies {
	// project
	implementation(project(Dependencies.Project.data))
	implementation(project(Dependencies.Project.common))
	implementation(project(Dependencies.Project.alphabet))
	implementation(project(Dependencies.Project.quiz))
	implementation(project(Dependencies.Project.settings))

	implementation(Androidx.Compose.librares)
	implementation(Androidx.librares)
	implementRoom()
	// hilt
	implementation(Dagger.hilt)
	kapt(Dagger.hiltCompiler)
	// coroutines
	implementation(Kotlinx.Coroutines.android)
	// timber log
	implementation(Dependencies.Others.timber)
	// compose directions
	implementation(ComposeDestinations.bottomSheet)
	implementation(ComposeDestinations.core)
	ksp(ComposeDestinations.ksp)
	//compose state events
	implementation(Dependencies.Others.composeStateEvents)
	//admob
	implementation(Dependencies.Others.playServicesAds)

	//Test
	testImplementation(Dependencies.Others.junit)
	testImplementation(Kotlinx.Coroutines.android)
	testImplementation(Kotlinx.Coroutines.test)
	androidTestImplementation(Androidx.Compose.uiTestJunit4)
	androidTestImplementation(Dagger.hiltAndroidTesting)
	androidTestImplementation(Androidx.junit)
	androidTestImplementation(Androidx.espresso)
	debugImplementation(Androidx.Compose.uiTooling)
	debugImplementation(Androidx.Compose.uiTestManifest)
	kaptAndroidTest(Dagger.hiltCompiler)
}
