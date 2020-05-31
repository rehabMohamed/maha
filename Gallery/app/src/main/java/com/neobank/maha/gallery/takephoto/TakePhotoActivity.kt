package com.neobank.maha.gallery.takephoto

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.core.content.FileProvider
import com.neobank.maha.gallery.Gallery.Companion.appComponent
import com.neobank.maha.gallery.R
import com.neobank.maha.gallery.takephoto.di.TakePhotoModule
import com.neobank.maha.gallery.utils.loadImage
import kotlinx.android.synthetic.main.activity_take_photo.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class TakePhotoActivity : AppCompatActivity(), TakePhotoView {

    @Inject
    lateinit var presenter: TakePhotoPresenter

    private lateinit var currentPhotoPath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        setContentView(R.layout.activity_take_photo)
        initListeners()
        launchCamera()
    }

    private fun inject() {
        appComponent.takePhotoComponent(TakePhotoModule(this))
            .inject(this)
    }

    private fun initListeners() {
        savePhoto.setOnClickListener {
            //This check should be in presenter and return callback to continue
            var name = photoName.text.toString()
            if (name.isEmpty()) {
                name = photoName.hint.toString()
            }
            presenter.savePhoto(name, currentPhotoPath, Date())
        }
    }

    private fun launchCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { imageCaptureIntent ->
            imageCaptureIntent.resolveActivity(packageManager)?.also {
                // Create file to save the captured image
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    null
                }
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                        this,
                        AUTHORITY,
                        it
                    )
                    imageCaptureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(imageCaptureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            loadImage(this, currentPhotoPath, imageView)
        } else {
            // image not captured
            closeScreen()
        }
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.ENGLISH).format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(timeStamp, ".jpg", storageDir)
            .apply {
                currentPhotoPath = absolutePath
            }
    }

    override fun closeScreen() {
        finish()
    }

    companion object{
        private const val REQUEST_IMAGE_CAPTURE = 1
        private const val AUTHORITY = "com.neobank.maha.gallery.fileprovider"

    }
}
