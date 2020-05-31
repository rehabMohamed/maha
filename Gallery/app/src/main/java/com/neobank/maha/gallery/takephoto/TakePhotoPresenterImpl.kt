package com.neobank.maha.gallery.takephoto

import com.neobank.maha.gallery.base.BasePresenter
import com.neobank.maha.gallery.data.PhotoEntity
import com.neobank.maha.gallery.data.PhotosDao
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.Date

class TakePhotoPresenterImpl(private val view: TakePhotoView?, private val photosDao: PhotosDao)
    : BasePresenter(), TakePhotoPresenter {

    override fun savePhoto(name: String, url: String, createdAt: Date) {
        compositeDisposable?.add(
            photosDao.insertPhoto(PhotoEntity(name = name, url = url, createdAt = createdAt))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    view?.closeScreen()
                }
        )
    }

}