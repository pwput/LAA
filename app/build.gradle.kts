
plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("com.google.devtools.ksp")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}



android {
    namespace ="pl.pw.laa"
    compileSdk =33

    defaultConfig {
        applicationId ="pl.pw.laa"
        minSdk= 24
        targetSdk =33
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
    packagingOptions {
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
    // material
    implementation("androidx.compose.material3:material3:1.1.0-beta01")
    // compose
    implementation("androidx.compose.ui:ui:${Versions.compose_version}")
    implementation("androidx.activity:activity-compose:${Versions.activity_version}")
    implementation("androidx.compose.material:material:${Versions.compose_version}")
    implementation("androidx.compose.material:material-icons-extended:${Versions.compose_version}")
    implementation("androidx.compose.foundation:foundation:${Versions.compose_version}")
    implementation("androidx.compose.foundation:foundation-layout:${Versions.compose_version}")
    implementation("androidx.compose.animation:animation:${Versions.compose_version}")
    implementation("androidx.compose.runtime:runtime:${Versions.compose_version}")
    implementation("androidx.compose.runtime:runtime-livedata:${Versions.compose_version}")
    implementation("androidx.navigation:navigation-compose:${Versions.compose_NavVersion}")
    implementation("androidx.compose.ui:ui-tooling:${Versions.compose_version}")
    implementation("androidx.constraintlayout:constraintlayout-compose:${Versions.constraint_version}")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Versions.compose_version}")
    // Room
    implementation("androidx.room:room-runtime:${Versions.room_version}")
    annotationProcessor("androidx.room:room-compiler:${Versions.room_version}")
    kapt("androidx.room:room-compiler:${Versions.room_version}")
    implementation("androidx.room:room-ktx:${Versions.room_version}")
    // hilt
    implementation("com.google.dagger:hilt-android:${Versions.hilt_version}")
    implementation("androidx.hilt:hilt-navigation-compose:${Versions.hiltComposeNavigation}")
    kapt("com.google.dagger:hilt-compiler:${Versions.hilt_version}")
    androidTestImplementation("com.google.dagger:hilt-android-testing:${Versions.hilt_version}")
    kaptAndroidTest("com.google.dagger:hilt-compiler:${Versions.hilt_version}")
    // coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines_version}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines_version}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines_version}")
    // timber log
    implementation("com.jakewharton.timber:timber:5.0.1")
    // compose directions
    implementation("io.github.raamcosta.compose-destinations:animations-core:${Versions.destinations_version}")
    kapt("io.github.raamcosta.compose-destinations:ksp:${Versions.destinations_version}")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Versions.compose_version}")
    debugImplementation("androidx.compose.ui:ui-tooling:${Versions.compose_version}")
    debugImplementation("androidx.compose.ui:ui-test-manifest:${Versions.compose_version}")

    implementation("androidx.startup:startup-runtime:1.1.1")
}
