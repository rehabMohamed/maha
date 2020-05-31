package com.neobank.maha.gallery.photolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.neobank.maha.gallery.Gallery.Companion.appComponent
import com.neobank.maha.gallery.R
import com.neobank.maha.gallery.photo.PhotoActivity
import com.neobank.maha.gallery.photo.PhotoActivity.Companion.PHOTO_URL
import com.neobank.maha.gallery.photolist.di.PhotoListModule
import com.neobank.maha.gallery.takephoto.Photo
import kotlinx.android.synthetic.main.activity_photo_list.*
import javax.inject.Inject

class PhotoListActivity : AppCompatActivity(), PhotoListView {

    @Inject
    lateinit var presenter: PhotoListPresenter

    @Inject
    lateinit var photoAdapter: PhotoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inject()

        setContentView(R.layout.activity_photo_list)

        photoAdapter.clickListener = ::onPhotoClick

        recyclerView.apply {
            adapter = photoAdapter
            layoutManager =
                StaggeredGridLayoutManager(GRID_COUNT, StaggeredGridLayoutManager.VERTICAL)
        }
    }

    private fun inject() {
        appComponent.photoListComponent(PhotoListModule(this))
            .inject(this)
    }

    override fun updatePhotoList(photoList: List<Photo>) {
        photoAdapter.updatePhotos(photoList)
    }

    private fun onPhotoClick(url: String) {
        val intent = Intent(this, PhotoActivity::class.java)
        intent.putExtra(PHOTO_URL, url)
        startActivity(intent)
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }

    companion object {
        const val GRID_COUNT = 3
    }
}
