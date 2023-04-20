package pl.pw.laa.presistence

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.pw.laa.data.dao.AppConfigKeyDao
import pl.pw.laa.model.AppConfigKey

@Database(entities = [AppConfigKey::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun applicationSettingsDao(): AppConfigKeyDao
}
