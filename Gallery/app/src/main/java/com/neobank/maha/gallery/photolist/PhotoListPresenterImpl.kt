package com.neobank.maha.gallery.photolist

import com.neobank.maha.gallery.base.BasePresenter
import com.neobank.maha.gallery.data.PhotoEntity
import com.neobank.maha.gallery.data.PhotosDao
import com.neobank.maha.gallery.takephoto.Photo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PhotoListPresenterImpl(private val view: PhotoListView?, private val photosDao: PhotosDao) :
    BasePresenter(), PhotoListPresenter {

    init {
        fetchPhotoList()
    }

    private fun fetchPhotoList() {

        compositeDisposable?.add(
            photosDao.fetchAllItems()
                .subscribeOn(Schedulers.io())
                .map { mapPhoto(it) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    it?.let {
                        view?.updatePhotoList(it)
                    }
                }
        )
    }

    private fun mapPhoto(photoEntityList: List<PhotoEntity>) : List<Photo> {
        val photoList = mutableListOf<Photo>()
        photoEntityList.forEach { photoEntity->
            photoList.add(Photo(photoEntity.name, photoEntity.url, photoEntity.createdAt))
        }
        return photoList
    }
}