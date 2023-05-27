package pl.pw.laa.data.presistence

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import pl.pw.laa.data.R
import pl.pw.laa.data.model.AppConfigKey
import javax.inject.Inject
import javax.inject.Singleton

sealed class ConfigKey<in T>(val key: String, val name: String){
    abstract suspend fun getValue():Any
    abstract suspend fun setValue(value: T)
}

private fun Int.toBoolean(): Boolean = this == 1

private fun Boolean.toInt(): Int = if (this) 1 else 0

@Singleton
class AppConfig @Inject constructor(@ApplicationContext private val context: Context, private val repository: AppConfigKeyRepository) {

    val answers = ConfigKeyInt(KeyNames.NumberOfAnswers.value, context.getString(KeyNames.NumberOfAnswers.resId))
    val cheats = ConfigKeyBoolean(KeyNames.AreCheats.value,context.getString(KeyNames.AreCheats.resId,))
    val tips = ConfigKeyBoolean(KeyNames.AreTips.value,context.getString(KeyNames.AreTips.resId))
    val initial = ConfigKeyBoolean(KeyNames.IsInitial.value,context.getString(KeyNames.IsInitial.resId))
    val medial = ConfigKeyBoolean(KeyNames.IsMedial.value,context.getString(KeyNames.IsMedial.resId))
    val final = ConfigKeyBoolean(KeyNames.IsFinal.value,context.getString(KeyNames.IsFinal.resId))
    val isolated = ConfigKeyBoolean(KeyNames.IsIsolated.value,context.getString(KeyNames.IsIsolated.resId))

    inner class ConfigKeyBoolean(key: String, name: String) : ConfigKey<Boolean>(key, name) {
        override suspend fun getValue(): Boolean {
            return repository.getAppConfigKey(key).first().value.toBoolean()
        }

        override suspend fun setValue(value: Boolean) {
            repository.addAppConfigKey(AppConfigKey(key,name, value.toInt()))
        }

    }
    inner class ConfigKeyInt(key: String, name: String) : ConfigKey<Int>(key, name) {
        override suspend fun getValue(): Int {
            return repository.getAppConfigKey(key).first().value
        }

        override suspend fun setValue(value: Int) {
            repository.addAppConfigKey(AppConfigKey(key, name, value))
        }
    }
}



enum class KeyNames(val value: String,val resId: Int){
    NumberOfAnswers( "numberOfAnswers" , R.string.app_config_answers_display_name),
    AreCheats ("cheats", R.string.app_config_are_cheats_display_name),
    AreTips ("tips", R.string.app_config_are_tips_display_name),
    IsInitial ("isInitialTested", R.string.app_config_is_initial_display_name),
    IsMedial ("isMedialTested", R.string.app_config_is_medial_display_name),
    IsFinal ("isFinalTested", R.string.app_config_is_final_display_name),
    IsIsolated ("isIsolatedTested", R.string.app_config_is_isolated_display_name),
}

object DefaultKeys {
    val all = listOf(
        AppConfigKey(KeyNames.NumberOfAnswers.value, "answers", 8),
        AppConfigKey(KeyNames.AreCheats.value, "cheats", 1),
        AppConfigKey(KeyNames.AreTips.value, "tips", 1),
        AppConfigKey(KeyNames.IsInitial.value, "Initial", 1),
        AppConfigKey(KeyNames.IsMedial.value, "Medial", 1),
        AppConfigKey(KeyNames.IsFinal.value, "Final", 1),
        AppConfigKey(KeyNames.IsIsolated.value, "Isolated", 1),
    )}