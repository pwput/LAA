import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.buildscript
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.version
import pl.pw.buildsrc.Dependencies
import pl.pw.buildsrc.extensions.*


allprojects{
    buildscript {
        repositories {
            google()
            mavenCentral()
        }
        dependencies {
            classpath("com.android.tools.build:gradle:8.1.1")
            classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
            classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}")
        }
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}
    android {
        namespace ="pl.pw.laa.${name}"
        compileSdk =33
        defaultConfig {
            minSdk= 24

            testInstrumentationRunner ="androidx.test.runner.AndroidJUnitRunner"
            vectorDrawables {
                useSupportLibrary= true
            }
        }

        buildTypes {
            release {
                //minifyEnabled =false
                proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            }
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility= JavaVersion.VERSION_17
        }
        kotlinOptions {
            jvmTarget = "17"
        }
        buildFeatures {
            compose= true
        }
        composeOptions {
            kotlinCompilerExtensionVersion ="1.4.0"
        }
        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }

    }


dependencies {
    implementation(Dependencies.Androidx.Compose.librares)
    implementation(Dependencies.Androidx.librares)

    // hilt
    implementation(Dependencies.Dagger.hilt)
    kapt(Dependencies.Dagger.hiltCompiler)
    // coroutines
    implementation(Dependencies.Kotlinx.Coroutines.android)
    // timber log
    implementation(Dependencies.Others.timber)
    //compose state events
    implementation(Dependencies.Others.composeStateEvents)


    //Test
    testImplementation(Dependencies.Others.junit)
    testImplementation(Dependencies.Kotlinx.Coroutines.android)
    testImplementation(Dependencies.Kotlinx.Coroutines.test)
    androidTestImplementation(Dependencies.Androidx.Compose.uiTestJunit4)
    androidTestImplementation(Dependencies.Dagger.hiltAndroidTesting)
    androidTestImplementation(Dependencies.Androidx.junit)
    androidTestImplementation(Dependencies.Androidx.espresso)
    debugImplementation(Dependencies.Androidx.Compose.uiTooling)
    debugImplementation(Dependencies.Androidx.Compose.uiTestManifest)
    kaptAndroidTest(Dependencies.Dagger.hiltCompiler)
}