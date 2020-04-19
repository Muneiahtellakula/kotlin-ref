package com.example.roomdatabase.Database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {


    @Insert
    fun insert(studentsDetails: StudentsDetails)


    @Query("select * from student_details")
    fun getAll():LiveData<List<StudentsDetails>>

    @Query("DELETE FROM student_details")
    fun deleteAll()


    @Update
    fun update(studentsDetails: StudentsDetails)

    @Query("UPDATE student_details SET student_id = :word WHERE student_id == :id")
    fun updateItem(word: String, id: Int)

    @Delete
    fun deleteWord(studentsDetails: StudentsDetails)

}