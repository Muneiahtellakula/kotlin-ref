package com.muneiah.myexamtest

import android.app.Application
import androidx.lifecycle.LiveData

class ComicRepository(application: Application){

    private val comicDao : Comic_Dao
    private val comicList : LiveData<List<ComicDataModelEntity>>
    init {
        val comicDatabase:ComicDatabase = ComicDatabase.getInstance(application)
        comicDao = comicDatabase.comicDao
        comicList = comicDao.getAll()
    }
    fun getAll():LiveData<List<ComicDataModelEntity>>{
        return comicList
    }

    fun insert(studentDetails: ComicDataModelEntity){
        comicDao.insert(studentDetails)
    }

}