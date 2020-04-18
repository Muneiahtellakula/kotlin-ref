package com.example.roomdatabase.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface StudentDao {


    @Insert
    fun insertValues(studentsDetails: StudentsDetails)


    @Query("select * from student_details")
    fun getAll():LiveData<List<StudentsDetails>>

}