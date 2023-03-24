package pl.pw.laa.presistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.pw.laa.model.ApplicationSettings

@Dao
interface AppSettingsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApplicationSettings(applicationSettings: ApplicationSettings)

    @Query("SELECT * FROM ApplicationSettings WHERE id = :id_")
    fun getAppSettings(id_: Long): LiveData<ApplicationSettings>
}