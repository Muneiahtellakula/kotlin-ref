package com.muneiah.myexamtest

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface Comic_Dao
{
    @Insert
    fun insert(comicDataModelEntity: ComicDataModelEntity)


    @Query("select * from comic_details")
    fun getAll(): LiveData<List<ComicDataModelEntity>>

}