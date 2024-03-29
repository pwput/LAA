package pl.pw.buildsrc

object Dependencies {
	object Project {
		const val data = ":data"
		const val common = ":common"
		const val settings = ":settings"
		const val alphabet = ":alphabet"
		const val quiz = ":quiz"
	}

	object Others {
		const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
		const val junit = "junit:junit:4.13.2"
		const val composeStateEvents = "com.github.leonard-palm:compose-state-events:${
			Versions.composeStateEvents
		}"
		const val playServicesAds = "com.google.android.gms:play-services-ads:${Versions.playServicesAds}"
	}

	object Kotlinx {
		object Coroutines {
			const val android =
					"org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
			const val test =
					"org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
		}
	}

	object ComposeDestinations {
		const val bottomSheet =
				"io.github.raamcosta.compose-destinations:bottom-sheet:${Versions.destinations}"
		const val core =
				"io.github.raamcosta.compose-destinations:core:${Versions.destinations}"
		const val ksp = "io.github.raamcosta.compose-destinations:ksp:${Versions.destinations}"
	}

	object Androidx {
		const val startup = "androidx.startup:startup-runtime:${Versions.startup}"
		const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
		const val lifecycleRuntimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycleRuntimeCompose}"
		const val navigationCompose =
				"androidx.navigation:navigation-compose:${Versions.navigationCompose}"
		const val constraintlayoutCompose =
				"androidx.navigation:navigation-compose:${Versions.navigationCompose}"
		const val hiltNavigationCompose =
				"androidx.hilt:hilt-navigation-compose:${Versions.hiltComposeNavigation}"
		const val junit = "androidx.test.ext:junit:1.1.5"
		const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
		const val datastorePreferences = "androidx.datastore:datastore-preferences:1.0.0"
		const val splashscreen = "androidx.core:core-splashscreen:1.0.0"

		val librares = listOf(startup, activityCompose, navigationCompose, lifecycleRuntimeCompose, constraintlayoutCompose, hiltNavigationCompose, junit, espresso, datastorePreferences, splashscreen)

		object Compose {
			const val material3 = "androidx.compose.material3:material3:${Versions.material3}"
			const val ui = "androidx.compose.ui:ui:${Versions.compose}"
			const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
			const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
			const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
			const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
			const val foundationLayout =
					"androidx.compose.foundation:foundation-layout:${Versions.compose}"
			const val animation = "androidx.compose.animation:animation:${Versions.compose}"
			const val runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
			const val runtimeLivedata =
					"androidx.compose.runtime:runtime-livedata:${Versions.compose}"

			val librares = listOf(material3, ui, uiTooling, uiTestJunit4, uiTestManifest, foundation, foundationLayout, animation, runtime, runtimeLivedata)
		}

		object Room {
			const val runtime = "androidx.room:room-runtime:${Versions.room}"
			const val compiler = "androidx.room:room-compiler:${Versions.room}"
			const val ktx = "androidx.room:room-ktx:${Versions.room}"
		}
	}

	object Dagger {
		const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
		const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
		const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
	}
}