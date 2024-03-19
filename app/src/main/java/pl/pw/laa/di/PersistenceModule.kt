package pl.pw.laa.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pl.pw.laa.data.repository.IUserPreferencesRepository
import pl.pw.laa.data.repository.UserPreferencesRepository
import javax.inject.Singleton

val Context.userDataStore by preferencesDataStore("user_preferences")

@Module
@InstallIn(SingletonComponent::class)
abstract class UserPreferencesModule {

	// binds instance of MyUserPreferencesRepository
	@Binds
	@Singleton
	abstract fun bindUserPreferencesRepository(
			userPreferencesRepository: UserPreferencesRepository
	): IUserPreferencesRepository

	companion object {

		// provides instance of DataStore
		@Provides
		@Singleton
		fun provideUserDataStorePreferences(
				@ApplicationContext applicationContext: Context
		): DataStore<Preferences> {
			return applicationContext.userDataStore
		}
	}
}
