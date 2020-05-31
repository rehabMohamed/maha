package com.neobank.maha.gallery.takephoto


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neobank.maha.gallery.Gallery.Companion.appComponent
import com.neobank.maha.gallery.R
import com.neobank.maha.gallery.takephoto.di.TakePhotoModule
import javax.inject.Inject

class TakePhotoActivity : AppCompatActivity(), TakePhotoView {

    @Inject
    lateinit var presenter: TakePhotoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        setContentView(R.layout.activity_take_photo)
    }

    private fun inject() {
        appComponent.takePhotoComponent(TakePhotoModule(this))
            .inject(this)
    }
}
