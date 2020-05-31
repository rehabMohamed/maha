package com.neobank.maha.gallery.photolist

import com.neobank.maha.gallery.base.BasePresenter
import com.neobank.maha.gallery.data.PhotosDao

class PhotoListPresenterImpl(private val view: PhotoListView?, private val photosDao: PhotosDao) :
    BasePresenter(), PhotoListPresenter {

    init {
        fetchPhotoList()
    }

    private fun fetchPhotoList() {
        view?.updatePhotoList(emptyList())
    }


}