package pl.pw.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.pw.data.model.KeyNames.appConfigAnswers
import pl.pw.data.model.KeyNames.appConfigCheats
import pl.pw.data.model.KeyNames.appConfigIsFinalTested
import pl.pw.data.model.KeyNames.appConfigIsInitialTested
import pl.pw.data.model.KeyNames.appConfigIsIsolatedTested
import pl.pw.data.model.KeyNames.appConfigIsMedialTested
import pl.pw.data.model.KeyNames.appConfigTips
import pl.pw.data.presistence.AppConfigKeyRepository
import javax.inject.Inject
import javax.inject.Singleton

@Entity
class AppConfigKey(
    @PrimaryKey
    val key: String,
    val name: String,
    val value: Int,
)

@Singleton
class AppConfig @Inject constructor(private val repository: AppConfigKeyRepository) {

    val answers = repository.getAppConfigKey(appConfigAnswers)
    val cheats = repository.getAppConfigKey(appConfigCheats)
    val tips = repository.getAppConfigKey(appConfigTips)
    val initial = repository.getAppConfigKey(appConfigIsInitialTested)
    val medial = repository.getAppConfigKey(appConfigIsMedialTested)
    val final = repository.getAppConfigKey(appConfigIsFinalTested)
    val isolated = repository.getAppConfigKey(appConfigIsIsolatedTested)

    val all = listOf(
        answers,
        cheats,
        tips,
        initial,
        medial,
        final,
        isolated,
    )
}

object DefaultKeys {
    val all = listOf(
        AppConfigKey(appConfigAnswers, "answers", 8),
        AppConfigKey(appConfigCheats, "cheats", 1),
        AppConfigKey(appConfigTips, "tips", 1),
        AppConfigKey(appConfigIsInitialTested, "Initial", 1),
        AppConfigKey(appConfigIsMedialTested, "Medial", 1),
        AppConfigKey(appConfigIsFinalTested, "Final", 1),
        AppConfigKey(appConfigIsIsolatedTested, "Isolated", 1),
    )

    fun getDefaultKey(key: String) = all.find { it.key == key }
}

fun AppConfigKeyNew(key: String, newValue: Int): AppConfigKey {
    val tmp = DefaultKeys.all.find { it.key == key }
    return AppConfigKey(tmp!!.key, tmp.name, newValue)
}

object KeyNames {
    const val appConfigAnswers = "numberOfAnswers"
    const val appConfigCheats = "cheats"
    const val appConfigTips = "tips"
    const val appConfigIsInitialTested = "isInitialTested"
    const val appConfigIsMedialTested = "isMedialTested"
    const val appConfigIsFinalTested = "isFinalTested"
    const val appConfigIsIsolatedTested = "isIsolatedTested"
}
