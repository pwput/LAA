package pl.pw.laa.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class AppConfigKey(
    @PrimaryKey
    val key: String,
    val value: Int
)
const val appConfigAnswers = "numberOfAnswers"
const val appConfigCheats = "cheats"
const val appConfigTips = "tips"

