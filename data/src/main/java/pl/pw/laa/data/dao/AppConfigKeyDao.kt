package pl.pw.laa.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.pw.laa.data.model.AppConfigKey

@Dao
interface AppConfigKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertApplicationSettings(appConfigKey: AppConfigKey)

    @Query("SELECT * FROM AppConfigKey WHERE key = :name_")
    fun getAppSettingsKey(name_: String): Flow<AppConfigKey>

    @Query("SELECT value FROM AppConfigKey WHERE key = 'numberOfAnswers'")
    fun getNumber(): Int

    @Query("SELECT * FROM AppConfigKey ")
    fun getAppSettingsKey(): Flow<List<AppConfigKey>>
}
