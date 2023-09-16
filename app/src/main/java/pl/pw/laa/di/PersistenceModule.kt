package pl.pw.laa.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pl.pw.laa.R
import pl.pw.laa.data.dao.AppConfigKeyDao
import pl.pw.laa.data.presistence.AppConfigKeyRepository
import pl.pw.laa.data.presistence.AppDatabase
import pl.pw.laa.data.repository.AppConfigKeyRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    private const val DATABASE_DIR = "database/AppConfigData1.db"

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room
            .databaseBuilder(
                appContext,
                AppDatabase::class.java,
                appContext.getString(R.string.database),
            )
            .createFromAsset(DATABASE_DIR)
            .build()
    }

    @Provides
    @Singleton
    fun provideApplicationSettingsDao(appDatabase: AppDatabase): AppConfigKeyDao {
        return appDatabase.applicationSettingsDao()
    }

    @Provides
    @Singleton
    fun provideAppConfigKeyRepository(appConfigKeyDao: AppConfigKeyDao): AppConfigKeyRepository {
        return AppConfigKeyRepositoryImpl(appConfigKeyDao)
    }
}
