package com.example.roomdatabase.Database

import android.app.Application
import androidx.lifecycle.LiveData

class StudentRepository (application: Application){
    private val studentDao:StudentDao
    private val studentList:LiveData<List<StudentsDetails>>
    init {
        val studentDataBase:StudentDataBase= StudentDataBase.getInstance(application)
        studentDao=studentDataBase.stdentDao
        studentList=studentDao.getAll()

    }

    private fun insertMethod(studentsDetails: StudentsDetails) {
        studentDao.insertValues(studentsDetails)


    }

    private fun getAllDataFromRep():LiveData<List<StudentsDetails>> {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return  studentList
    }

}