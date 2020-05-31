package com.neobank.maha.gallery.photolist.di

import com.neobank.maha.gallery.di.ActivityScope
import com.neobank.maha.gallery.photolist.di.PhotoListModule
import com.neobank.maha.gallery.photolist.PhotoListActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [PhotoListModule::class])
interface PhotoListComponent {
    fun inject(activity: PhotoListActivity)
}