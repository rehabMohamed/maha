package com.neobank.maha.gallery.takephoto

import java.util.Date

interface TakePhotoPresenter {
    fun savePhoto(name: String, url: String, createdAt: Date)
}