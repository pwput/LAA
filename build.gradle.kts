allprojects {
    buildscript {
        dependencies {
            classpath("com.android.tools.build:gradle:8.1.1")
            classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.20")
            classpath("com.google.dagger:hilt-android-gradle-plugin:2.44")
        }
    }
}

tasks.register("test", Test::class){
    testLogging {
        events("started", "skipped", "passed", "failed")
    }
}
