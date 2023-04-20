package pl.pw.laa.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pl.pw.laa.R
import pl.pw.laa.data.dao.AppConfigKeyDao
import pl.pw.laa.data.repository.AppConfigKeyRepositoryImpl
import pl.pw.laa.presistence.AppDatabase
import pl.pw.laa.presistence.AppConfigKeyRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room
            .databaseBuilder(
                appContext,
                AppDatabase::class.java,
                appContext.getString(R.string.database),
            )
            .fallbackToDestructiveMigration()
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
