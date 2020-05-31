package com.neobank.maha.gallery

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.neobank.maha.gallery.data.AppDatabase
import com.neobank.maha.gallery.data.PhotoEntity
import com.neobank.maha.gallery.data.PhotosDao
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.Date

@RunWith(AndroidJUnit4::class)
class AppDatabaseReadWriteTest {
    private lateinit var photosDao: PhotosDao
    private lateinit var db: AppDatabase

    @JvmField
    @Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).allowMainThreadQueries()
            .build()
        photosDao = db.photosDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writePhotoAndReadInList() {
        val photo = PhotoEntity(name = "phototest", url = "url", createdAt = Date())
        photosDao.insertPhoto(photo).blockingAwait()


        photosDao.fetchAllItems().test()
            .assertValue { list ->
                list.isNotEmpty() && list[0].name == photo.name
            }

    }
}