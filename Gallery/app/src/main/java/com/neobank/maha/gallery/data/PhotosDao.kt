package com.neobank.maha.gallery.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.neobank.maha.gallery.data.PhotoEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import org.jetbrains.annotations.NotNull

@Dao
interface PhotosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhoto(@NotNull photo: PhotoEntity): Completable

    @Query("SELECT * FROM Photo WHERE name = :photoName")
    fun fetchByName(photoName: String): List<PhotoEntity>

    @Query("SELECT * FROM Photo")
    fun fetchAllItems(): Flowable<List<PhotoEntity>>
}