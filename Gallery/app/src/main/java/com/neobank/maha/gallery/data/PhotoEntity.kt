package com.neobank.maha.gallery.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "Photo")
class PhotoEntity(@PrimaryKey(autoGenerate = true) var id: Int = 0,
                  val name: String,
                  val url: String,
                  val createdAt: Date)