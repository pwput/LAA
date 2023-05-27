package pl.pw.laa.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pl.pw.laa.R
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): pl.pw.data.presistence.AppDatabase {
        return Room
            .databaseBuilder(
                appContext,
                pl.pw.data.presistence.AppDatabase::class.java,
                appContext.getString(R.string.database),
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideApplicationSettingsDao(appDatabase: pl.pw.data.presistence.AppDatabase): pl.pw.data.dao.AppConfigKeyDao {
        return appDatabase.applicationSettingsDao()
    }

    @Provides
    @Singleton
    fun provideAppConfigKeyRepository(appConfigKeyDao: pl.pw.data.dao.AppConfigKeyDao): pl.pw.data.presistence.AppConfigKeyRepository {
        return pl.pw.data.repository.AppConfigKeyRepositoryImpl(appConfigKeyDao)
    }
}
