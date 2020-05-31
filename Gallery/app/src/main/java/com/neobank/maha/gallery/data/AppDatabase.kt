package com.neobank.maha.gallery.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.neobank.maha.gallery.data.DateConverter
import com.neobank.maha.gallery.data.PhotoEntity
import com.neobank.maha.gallery.data.PhotosDao

@Database(entities = [PhotoEntity::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun photosDao(): PhotosDao

    companion object {
        const val NAME = "app_database"
    }
}