package com.neobank.maha.gallery.di

import android.content.Context
import androidx.room.Room
import com.neobank.maha.gallery.data.AppDatabase
import com.neobank.maha.gallery.data.PhotosDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val appContext: Context) {

    @Provides
    @Singleton
    fun provideAppDatabase(): AppDatabase =
        Room.databaseBuilder(appContext.applicationContext, AppDatabase::class.java, AppDatabase.NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providePhotosDao(db: AppDatabase): PhotosDao =
        db.photosDao()
}