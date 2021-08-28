package com.smitcoderx.keepit.Di

import android.app.Application
import androidx.room.Room
import com.smitcoderx.keepit.Db.KeepItDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application) =
        Room.databaseBuilder(app, KeepItDatabase::class.java, "Notes.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun keepitDao(db: KeepItDatabase) =
        db.keepitDao()

}