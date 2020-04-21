package com.muneiah.myexamtest

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class MainViewModel(application: Application): AndroidViewModel(application) {
    val comicRepository: ComicRepository
    val allComics: LiveData<List<ComicDataModelEntity>>

    init {
        comicRepository = ComicRepository(application)
        allComics = comicRepository.getAll()
        Timber.i("Main View Model Initilize")

    }

    fun insert(comicDataModelEntity: ComicDataModelEntity) {
        comicRepository.insert(comicDataModelEntity)
    }
}

