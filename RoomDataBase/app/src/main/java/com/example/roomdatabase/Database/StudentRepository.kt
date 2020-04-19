package com.example.roomdatabase.Database

import android.app.Application
import androidx.lifecycle.LiveData

class StudentRepository(application: Application){

    private val studentDao : StudentDao
    private val studentlist : LiveData<List<StudentsDetails>>

    init {
        val studentDatabase:StudentDatabase = StudentDatabase.getInstance(application)
        studentDao = studentDatabase.studentDao
        studentlist = studentDao.getAll()
    }

    fun getAll():LiveData<List<StudentsDetails>>{
        return studentlist
    }

    fun insert(studentDetails: StudentsDetails){
        studentDao.insert(studentDetails)
    }

}