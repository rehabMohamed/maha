package com.neobank.maha.gallery.takephoto

import java.util.Date

class TakePhotoPresenterImpl(private val view: TakePhotoView?) : TakePhotoPresenter {

    override fun savePhoto(name: String, url: String, createdAt: Date) {
        // TODO: save the photo data in a database
        view?.closeScreen()
    }

}