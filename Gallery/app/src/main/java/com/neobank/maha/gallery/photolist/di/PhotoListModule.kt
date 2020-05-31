package com.neobank.maha.gallery.photolist.di

import com.neobank.maha.gallery.data.PhotosDao
import com.neobank.maha.gallery.di.ActivityScope
import com.neobank.maha.gallery.photolist.PhotoListActivity
import com.neobank.maha.gallery.photolist.PhotoListAdapter
import com.neobank.maha.gallery.photolist.PhotoListPresenter
import com.neobank.maha.gallery.photolist.PhotoListPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class PhotoListModule(var view: PhotoListActivity) {

    @Provides
    @ActivityScope
    fun providePresenter(photosDao: PhotosDao): PhotoListPresenter {
        return PhotoListPresenterImpl(view, photosDao)
    }

    @Provides
    @ActivityScope
    fun provideAdapter(): PhotoListAdapter {
        return PhotoListAdapter(view)
    }
}