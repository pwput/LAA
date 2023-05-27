package pl.pw.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
open class AppConfigKey(
    @PrimaryKey
    val key: String,
    val name: String,
    val value: Int,
)
