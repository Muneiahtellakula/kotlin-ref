package com.example.roomdatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.roomdatabase.Database.StudentDao
import com.example.roomdatabase.Database.StudentRepository
import com.example.roomdatabase.Database.StudentsDetails



class MainViewModel(application:Application):AndroidViewModel(application)
{
    val studentRepository : StudentRepository
    val allStudents : LiveData<List<StudentsDetails>>

    init {
        studentRepository = StudentRepository(application)
        allStudents = studentRepository.getAll()

    }

    fun insert(studentDetails: StudentsDetails){
        studentRepository.insert(studentDetails)
    }

    fun delete(){
        studentRepository.deleteAll()
    }

    fun update(studentDetails: StudentsDetails){
        studentRepository.update(studentDetails)
    }
    // Delete solo  DATA
    fun deleteWord(studentDetails: StudentsDetails) {
        studentRepository.deleteSolo(studentDetails)

    }


}