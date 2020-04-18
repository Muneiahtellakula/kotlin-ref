package com.example.roomdatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.roomdatabase.Database.StudentDao
import com.example.roomdatabase.Database.StudentRepository
import com.example.roomdatabase.Database.StudentsDetails

class MainViewModel(application: Application) :AndroidViewModel(application){

    private val studentRepository: StudentRepository
    private val allStudents: LiveData<List<StudentsDetails>>
    init {
        studentRepository=StudentRepository(application)
        allStudents = studentRepository.getAllDataFromRep()
    }

    fun insert(studentDetails: StudentsDetails){
        studentRepository.(studentDetails)
    }
}
