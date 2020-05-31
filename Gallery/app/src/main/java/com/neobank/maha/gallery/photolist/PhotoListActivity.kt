package com.neobank.maha.gallery.photolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neobank.maha.gallery.Gallery.Companion.appComponent
import com.neobank.maha.gallery.R
import com.neobank.maha.gallery.photolist.di.PhotoListModule
import javax.inject.Inject

class PhotoListActivity : AppCompatActivity(), PhotoListView {

    @Inject
    lateinit var presenter: PhotoListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inject()

        setContentView(R.layout.activity_photo_list)
    }

    private fun inject() {
        appComponent.photoListComponent(PhotoListModule(this))
            .inject(this)
    }
}
