package com.neobank.maha.gallery.takephoto.di

import com.neobank.maha.gallery.data.PhotosDao
import com.neobank.maha.gallery.di.ActivityScope
import com.neobank.maha.gallery.takephoto.TakePhotoActivity
import com.neobank.maha.gallery.takephoto.TakePhotoPresenter
import com.neobank.maha.gallery.takephoto.TakePhotoPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class TakePhotoModule(var view: TakePhotoActivity) {

    @Provides
    @ActivityScope
    fun providePresenter(photosDao: PhotosDao): TakePhotoPresenter {
        return TakePhotoPresenterImpl(view, photosDao)
    }
}