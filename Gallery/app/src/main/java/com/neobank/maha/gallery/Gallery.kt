package com.neobank.maha.gallery

import android.app.Application
import com.neobank.maha.gallery.di.AppModule
import com.neobank.maha.gallery.di.AppComponent
import com.neobank.maha.gallery.di.DaggerAppComponent

class Gallery : Application() {

    override fun onCreate() {
        super.onCreate()
        setupInjection()
    }

    private fun setupInjection() {
        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build();
        appComponent.inject(this);
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}