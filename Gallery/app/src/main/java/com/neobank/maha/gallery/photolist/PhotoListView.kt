package com.neobank.maha.gallery.photolist

import com.neobank.maha.gallery.takephoto.Photo

interface PhotoListView {

    fun updatePhotoList(photoList: List<Photo>)
}