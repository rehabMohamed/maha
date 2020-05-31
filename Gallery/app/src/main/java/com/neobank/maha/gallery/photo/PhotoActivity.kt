package com.neobank.maha.gallery.photo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.neobank.maha.gallery.R
import com.neobank.maha.gallery.utils.loadImage
import kotlinx.android.synthetic.main.activity_photo.*


class PhotoActivity : AppCompatActivity() {

    companion object {
        const val PHOTO_URL = "photo_url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_photo)
        val url = intent.getStringExtra(PHOTO_URL)

        loadImage(this, url, imageView)
    }
}