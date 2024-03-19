import pl.pw.buildsrc.Versions

allprojects{
    buildscript {
        dependencies {
            classpath("com.android.tools.build:gradle:${Versions.androidGradle}")
            classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
            classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}")
        }
    }
}
