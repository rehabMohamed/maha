package com.neobank.maha.gallery.takephoto.di

import com.neobank.maha.gallery.di.ActivityScope
import com.neobank.maha.gallery.takephoto.TakePhotoActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [TakePhotoModule::class])
interface TakePhotoComponent {
    fun inject(activity: TakePhotoActivity)
}