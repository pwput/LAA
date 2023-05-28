import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.buildscript
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.version
import pl.pw.buildsrc.Dependencies

allprojects{
    buildscript {
        repositories {
            google()
            mavenCentral()
        }
        dependencies {
            classpath("com.android.tools.build:gradle:8.0.2")
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
  //  id("com.google.devtools.ksp") version "1.8.0-1.0.9"
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
    // material
    implementation(Dependencies.Androidx.Compose.material3)
    // compose
    implementation(Dependencies.Androidx.Compose.ui)
    implementation(Dependencies.Androidx.Compose.material)
    implementation(Dependencies.Androidx.Compose.materialIconsExtended)
    implementation(Dependencies.Androidx.Compose.foundation)
    implementation(Dependencies.Androidx.Compose.foundationLayout)
    implementation(Dependencies.Androidx.Compose.animation)
    implementation(Dependencies.Androidx.Compose.runtime)
    implementation(Dependencies.Androidx.Compose.runtimeLivedata)
    implementation(Dependencies.Androidx.Compose.uiTooling)
    // androidx
    implementation(Dependencies.Androidx.startup)
    implementation(Dependencies.Androidx.navigationCompose)
    implementation(Dependencies.Androidx.constraintlayoutCompose)
    implementation(Dependencies.Androidx.activityCompose)
    implementation(Dependencies.Androidx.hiltNavigationCompose)
    // hilt
    implementation(Dependencies.Dagger.hilt)
    kapt(Dependencies.Dagger.hiltCompiler)
    // coroutines
    implementation(Dependencies.Kotlinx.Coroutines.android)
    // timber log
    implementation(Dependencies.Others.timber)


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