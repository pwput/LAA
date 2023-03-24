package pl.pw.laa.presistence

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.pw.laa.model.ApplicationSettings

@Database(entities = [ApplicationSettings::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun applicationSettingsDao(): AppSettingsDao
}
