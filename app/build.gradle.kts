import pl.pw.buildsrc.Dependencies
import pl.pw.buildsrc.Dependencies.Kotlinx
import pl.pw.buildsrc.Dependencies.Androidx
import pl.pw.buildsrc.Dependencies.ComposeDestinations
import pl.pw.buildsrc.Dependencies.Dagger

plugins {
    id ("com.android.application")
    kotlin("kapt")
    id ("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") version "1.8.0-1.0.9"
    id("dagger.hilt.android.plugin")
}
val composeStateEventsVersion by extra("1.2.3")

android {
    namespace ="pl.pw.laa"
    compileSdk =33
    defaultConfig {
        applicationId ="pl.pw.laa"
        minSdk= 24
        versionCode= 1
        versionName ="1.0"

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
        sourceCompatibility =JavaVersion.VERSION_17
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
    // material
    implementation(Androidx.Compose.material3)
    // compose
    implementation(Androidx.Compose.ui)
    implementation(Androidx.Compose.materialIconsExtended)
    implementation(Androidx.Compose.foundation)
    implementation(Androidx.Compose.foundationLayout)
    implementation(Androidx.Compose.animation)
    implementation(Androidx.Compose.runtime)
    implementation(Androidx.Compose.runtimeLivedata)
    implementation(Androidx.Compose.uiTooling)
    // androidx
    implementation(Androidx.startup)
    implementation(Androidx.navigationCompose)
    implementation(Androidx.constraintlayoutCompose)
    implementation(Androidx.activityCompose)
    implementation(Androidx.hiltNavigationCompose)
    // Room
    implementation(Androidx.Room.runtime)
    annotationProcessor(Androidx.Room.compiler)
    kapt(Androidx.Room.compiler)
    implementation(Androidx.Room.ktx)
    // hilt
    implementation(Dagger.hilt)
    kapt(Dagger.hiltCompiler)
    // coroutines
    implementation(Kotlinx.Coroutines.android)
    // timber log
    implementation(Dependencies.Others.timber)
    // compose directions
    implementation(ComposeDestinations.animationsCore)
    ksp(ComposeDestinations.ksp)
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.0-beta01")

    implementation ("com.github.leonard-palm:compose-state-events:$composeStateEventsVersion")


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
