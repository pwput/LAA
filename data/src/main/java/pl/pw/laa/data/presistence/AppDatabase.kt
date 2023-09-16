package pl.pw.laa.data.presistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import pl.pw.laa.data.dao.AppConfigKeyDao
import pl.pw.laa.data.model.AppConfigKey

@Database(entities = [AppConfigKey::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun applicationSettingsDao(): AppConfigKeyDao
}
