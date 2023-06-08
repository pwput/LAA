package pl.pw.laa.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint
import pl.pw.laa.presentation.NavGraphs
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor() : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        Timber.plant(Timber.DebugTree())
        setContent {
            LearnArabicAlphabetTheme (darkTheme = isSystemInDarkTheme()){
                Scaffold() {
                    Surface(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
                        DestinationsNavHost(navGraph = NavGraphs.root)

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearnArabicAlphabetTheme {
        Greeting("Android")
    }
}
