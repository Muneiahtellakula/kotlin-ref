package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.roomdatabase.Database.StudentDataBase
import com.example.roomdatabase.Database.StudentsDetails

class MainActivity : AppCompatActivity() {
lateinit var student_name:EditText
    lateinit var student_age:EditText
    lateinit var result_tv:TextView
    lateinit var studentDataBase: StudentDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        student_age=findViewById(R.id.age)
        student_name=findViewById(R.id.sname)
        result_tv=findViewById(R.id.result_label)
    }

    fun saveData(view: View) {
       /* val n=student_name.text.toString()
        val a:Int=student_age.text.toString().toInt()
        val studentsDetails:StudentsDetails= StudentsDetails(student_name = n,student_age = a)
        val StudentDataBase =StudentDataBase.getin*/
        val n = student_name.text.toString()
        val a : Int =(student_age.text.toString()).toInt()
        val studentDetails : StudentsDetails = StudentsDetails(student_name = n,student_age = a)
         studentDataBase = StudentDataBase.getInstance(this)
        studentDataBase.stdentDao.insertValues(studentDetails)
        Toast.makeText(this,"DATA INSERTION SUCCESSFUL",Toast.LENGTH_SHORT).show()
        displayData()
    }

    private fun displayData() {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val list:List<StudentsDetails> =studentDataBase.stdentDao.getAll()
        result_tv.text=""
        for(i in list){
            result_tv.append(""+i.student_id+" "+i.student_name+" "+i.student_age+"\n\n\n")
        }
    }
}
