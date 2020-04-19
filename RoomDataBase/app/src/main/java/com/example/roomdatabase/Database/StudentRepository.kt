package com.example.roomdatabase.Database

import android.app.Application
import android.os.AsyncTask
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
    fun deleteAll() {
        deleteAllWordsAsyncTask(studentDao).execute()
    }

    private class deleteAllWordsAsyncTask internal constructor(private val mAsyncTaskDao: StudentDao) :
        AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg voids: Void): Void? {
            mAsyncTaskDao.deleteAll()
            return null
        }
    }

    /* ---------------- Rid SOLO DATA---------------- */

    fun deleteWord(studentDetails: StudentsDetails) {
        deleteWordAsyncTask(studentDao).execute(studentDetails)
    }

    private class deleteWordAsyncTask internal constructor(private val mAsyncTaskDao: StudentDao) :
        AsyncTask<StudentsDetails, Void, Void>() {

        override fun doInBackground(vararg params: StudentsDetails): Void? {
            mAsyncTaskDao.deleteWord(params[0])
            return null
        }
    }
    //for update
    fun update(studentDetails: StudentsDetails) {
        updateWordAsyncTask(studentDao).execute(studentDetails)
    }

    private class updateWordAsyncTask internal constructor(private val mAsyncTaskDao: StudentDao) :
        AsyncTask<StudentsDetails, Void, Void>() {
        override fun doInBackground(vararg params: StudentsDetails?): Void? {
            mAsyncTaskDao.update(params[0]!!)
            return null
        }
    }

}