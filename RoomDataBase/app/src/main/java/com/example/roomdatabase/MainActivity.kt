package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabase.Database.StudentDatabase
import com.example.roomdatabase.Database.StudentsDetails

class MainActivity : AppCompatActivity() {
lateinit var student_name:EditText
    lateinit var student_age:EditText
    lateinit var result_tv_id:TextView
    lateinit var result_tv_name:TextView
    lateinit var result_tv_age:TextView
    lateinit var studentDataBase: StudentDatabase
   // val modelList:LiveData<List<StudentsDetails>>
lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        mainViewModel =  ViewModelProvider(this,MainViewModelFactory(application))
            .get(MainViewModel::class.java)

        mainViewModel.allStudents.observe(this, Observer { list ->
            displayData(list)
        })
    }

    private fun initViews() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        student_age=findViewById(R.id.sage)
        student_name=findViewById(R.id.sname)
        result_tv_age=findViewById(R.id.result_age)
        result_tv_id=findViewById(R.id.result_id)
        result_tv_name=findViewById(R.id.result_name)
    }

    fun saveData(view: View) {
        val n = student_name.text.toString()
        val a : Int = (student_age.text.toString()).toInt()
        val studentDetails : StudentsDetails = StudentsDetails(student_name = n,student_age = a)

        mainViewModel.insert(studentDetails)

        Toast.makeText(this,"DATA INSERTION SUCCESSFUL",Toast.LENGTH_SHORT).show()
        student_name.setText("")
        student_age.setText("")
        student_name.clearFocus()
        student_age.clearFocus()
    }

    private fun displayData(list: List<StudentsDetails>) {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     //   val list:List<StudentsDetails> =studentDataBase.stdentDao.getAll()
        result_tv_name.text=""
        result_tv_id.text=""
        result_tv_age.text=""
        for(i in list){
         /*   result_tv_id.append(""+i.student_id+" "+i.student_name+" "+i.student_age+"\n")
            result_tv_id.append(""+i.student_id+" "+i.student_name+" "+i.student_age+"\n")
            result_tv_id.append(""+i.student_id+" "+i.student_name+" "+i.student_age+"\n")*/
            result_tv_id.append("Id:"+i.student_id+"\n\n")
            result_tv_name.append("Name:"+i.student_name+"\n\n")
            result_tv_age.append("Age:"+i.student_age+"\n\n")
        }
    }

    fun removeData(view: View) {
        mainViewModel.delete()
    }
    fun updateData(view: View) {
        val a : Int = (student_age.text.toString()).toInt()
        val studentsDetails = StudentsDetails(student_name = a.toString())
        mainViewModel.update(studentsDetails)
       // mainViewModel.allWords


    }
}
