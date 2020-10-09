package com.example.runningtrackerapp.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.runningtrackerapp.db.RunningDatabase
import com.example.runningtrackerapp.di.Constants.KEY_FIRST_TIME_TOGGLE
import com.example.runningtrackerapp.di.Constants.KEY_NAME
import com.example.runningtrackerapp.di.Constants.KEY_WEIGHT
import com.example.runningtrackerapp.di.Constants.SHARED_PREFRENCES_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRunningDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        RunningDatabase::class.java,
        Constants.RUNNING_DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideRunDao(db:RunningDatabase) = db.getRunDao()

    @Singleton
    @Provides
    fun provideSharedPrefreces(@ApplicationContext app:Context) =
            app.getSharedPreferences(SHARED_PREFRENCES_NAME, Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideName(sharedPreferences: SharedPreferences) = sharedPreferences.getString(KEY_NAME,"") ?: ""

    @Singleton
    @Provides
    fun provideWeight(sharedPreferences: SharedPreferences) = sharedPreferences.getFloat(KEY_WEIGHT,80f)

    @Singleton
    @Provides
    fun provideFirstTimeToggle(sharedPreferences: SharedPreferences) = sharedPreferences.getBoolean(KEY_FIRST_TIME_TOGGLE,true)
}