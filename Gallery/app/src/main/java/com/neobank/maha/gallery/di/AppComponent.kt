package com.neobank.maha.gallery.di

import com.neobank.maha.gallery.Gallery
import com.neobank.maha.gallery.photolist.di.PhotoListComponent
import com.neobank.maha.gallery.photolist.di.PhotoListModule
import com.neobank.maha.gallery.takephoto.di.TakePhotoComponent
import com.neobank.maha.gallery.takephoto.di.TakePhotoModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(gallery: Gallery)
    fun photoListComponent(module: PhotoListModule) : PhotoListComponent
    fun takePhotoComponent(module: TakePhotoModule) : TakePhotoComponent
}