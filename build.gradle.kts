allprojects{
    buildscript {
        repositories {
            google()
            mavenCentral()
            jcenter()
            maven { url = uri("https://jitpack.io") }
            gradlePluginPortal()
        }
        dependencies {
            classpath("com.android.tools.build:gradle:8.0.2")
            classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
            classpath("com.google.dagger:hilt-android-gradle-plugin:2.44")
        }
    }
}
