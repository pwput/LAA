package pl.pw.laa.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.pw.data.repository.AppConfigKeyRepositoryImpl
import pl.pw.laa.presentation.NavGraphs
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var appConfigRepository: AppConfigKeyRepositoryImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
        setContent {
            LearnArabicAlphabetTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
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
