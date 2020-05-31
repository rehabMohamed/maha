package com.neobank.maha.gallery.base

import io.reactivex.disposables.CompositeDisposable

open class BasePresenter {
    var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    fun destroy() {
        compositeDisposable?.dispose()
        compositeDisposable = null
    }
}