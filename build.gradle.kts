allprojects{
    buildscript {
        repositories {
            google()
            mavenCentral()
        }
        dependencies {
            classpath("com.android.tools.build:gradle:8.0.2")
            classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
            classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt_version}")

        }
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
//    //id("com.android.application") version "8.0.2" apply false
//    //id("com.android.library") version "8.0.2" apply false
//    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
//    id("com.google.devtools.ksp") version "1.8.0-1.0.9"
    id("com.google.dagger.hilt.android") version "2.44" apply false
//    id("org.jetbrains.kotlin.jvm") version "1.8.0" apply false
}



