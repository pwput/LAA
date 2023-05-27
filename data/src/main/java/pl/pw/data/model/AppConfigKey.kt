package pl.pw.data.model

import android.content.Context
import androidx.room.Entity
import androidx.room.PrimaryKey
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import pl.pw.data.R
import pl.pw.data.presistence.AppConfigKeyRepository
import javax.inject.Inject
import javax.inject.Singleton

@Entity
open class AppConfigKey(
    @PrimaryKey
    val key: String,
    val name: String,
    val value: Int,
)
