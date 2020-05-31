package com.neobank.maha.gallery.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neobank.maha.gallery.R
import com.neobank.maha.gallery.photolist.PhotoListActivity
import com.neobank.maha.gallery.takephoto.TakePhotoActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initListeners()
    }

    private fun initListeners() {
        takePhoto.setOnClickListener {
            openTakePhotoScreen()
        }

        viewPhotos.setOnClickListener {
            openPhotoListScreen()
        }
    }

    private fun openTakePhotoScreen() {
        startActivity(Intent(this, TakePhotoActivity::class.java))
    }

    private fun openPhotoListScreen() {
        startActivity(Intent(this, PhotoListActivity::class.java))
    }
}
