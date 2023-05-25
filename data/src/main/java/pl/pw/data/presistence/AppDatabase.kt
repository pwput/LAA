package pl.pw.data.presistence

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.pw.data.dao.AppConfigKeyDao
import pl.pw.data.model.AppConfigKey

@Database(entities = [AppConfigKey::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun applicationSettingsDao(): AppConfigKeyDao
}
