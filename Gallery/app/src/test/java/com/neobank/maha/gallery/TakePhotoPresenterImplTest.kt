package com.neobank.maha.gallery

import com.neobank.maha.gallery.data.PhotosDao
import com.neobank.maha.gallery.takephoto.TakePhotoPresenterImpl
import com.neobank.maha.gallery.takephoto.TakePhotoView
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.util.Date
import java.util.concurrent.Callable


@RunWith(MockitoJUnitRunner::class)
class TakePhotoPresenterImplTest {

    lateinit var takePhotoPresenterImpl: TakePhotoPresenterImpl

    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    @Mock
    private lateinit var photosDao: PhotosDao

    @Mock
    private lateinit var takePhotoView: TakePhotoView

    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler: Callable<Scheduler?>? -> Schedulers.trampoline() }

        takePhotoPresenterImpl = spy(TakePhotoPresenterImpl(takePhotoView, photosDao))
        takePhotoPresenterImpl.compositeDisposable = compositeDisposable
    }

    @Test
    fun `test that insertPhoto method called`() {
        `when`(photosDao.insertPhoto(any())).thenReturn(Completable.complete())
        `when`(takePhotoPresenterImpl.compositeDisposable?.add(any())).thenReturn(true)
        takePhotoPresenterImpl.savePhoto(NAME, URL, DATE)
        verify(photosDao).insertPhoto(any())
        verify(takePhotoView).closeScreen()
    }

    companion object {
        private const val URL = "URL"
        private const val NAME = "TEST"
        private val DATE = Date()
    }
}