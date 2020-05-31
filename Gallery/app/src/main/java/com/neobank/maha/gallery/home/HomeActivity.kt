package com.neobank.maha.gallery.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neobank.maha.gallery.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initListiners()
    }

    private fun initListiners() {
        takePhoto.setOnClickListener {
            openTakePhotoScreen()
        }

        viewPhotos.setOnClickListener {
            openPhotoListScreen()
        }
    }

    private fun openTakePhotoScreen() {
        // TODO: open take photo screen
    }

    private fun openPhotoListScreen() {
        // TODO: open photo list screen
    }
}
