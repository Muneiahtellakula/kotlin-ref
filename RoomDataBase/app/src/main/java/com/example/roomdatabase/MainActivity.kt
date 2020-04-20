package com.example.roomdatabase

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.Database.StudentDatabase
import com.example.roomdatabase.Database.StudentsDetails

class MainActivity : AppCompatActivity() {
lateinit var student_name:EditText
    lateinit var student_age:EditText
    lateinit var student_id:EditText
    lateinit var result_tv_id:TextView
    lateinit var result_tv_name:TextView
    lateinit var result_tv_age:TextView
    lateinit var studentDataBase: StudentDatabase
    lateinit var recyclerView: RecyclerView
    lateinit var list: MutableList<List<StudentsDetails>>
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
        student_id=findViewById(R.id.st_id)
        recyclerView=findViewById(R.id.recycler_view)
       /* result_tv_age=findViewById(R.id.result_age)
        result_tv_id=findViewById(R.id.result_id)
        result_tv_name=findViewById(R.id.result_name)*/
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
       /* result_tv_name.text=""
        result_tv_id.text=""
        result_tv_age.text=""
        for(i in list){
         *//*   result_tv_id.append(""+i.student_id+" "+i.student_name+" "+i.student_age+"\n")
            result_tv_id.append(""+i.student_id+" "+i.student_name+" "+i.student_age+"\n")
            result_tv_id.append(""+i.student_id+" "+i.student_name+" "+i.student_age+"\n")*//*
            result_tv_id.append("Id:"+i.student_id+"\n\n")
            result_tv_name.append("Name:"+i.student_name+"\n\n")
            result_tv_age.append("Age:"+i.student_age+"\n\n")
        }*/
        val ra=RecyclerAdapter(this)
        //val ra=RecyclerAdapter(this,list)
        recyclerView.adapter=ra
        ra.submitList(list)
     //   recyclerView.adapter=ra
    }

    fun removeData(view: View) {
        mainViewModel.delete()

    }
    fun updateData() {
        val n = student_name.text.toString()
        val a : Int = (student_age.text.toString()).toInt()
       val studentsDetails = StudentsDetails(student_name = n,student_age = a)
        mainViewModel.update(studentsDetails)
    }
   // class RecyclerAdapter(val context: Context,val l:List<StudentsDetails>):RecyclerView.Adapter<RecylerViewHolder>(){
    class RecyclerAdapter(val context: Context):ListAdapter<StudentsDetails,RecylerViewHolder>(StudentDiffUtiill()){

        class StudentDiffUtiill :DiffUtil.ItemCallback<StudentsDetails>(){
            override fun areItemsTheSame(
                oldItem: StudentsDetails,
                newItem: StudentsDetails
            ): Boolean {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                return oldItem.student_id==newItem.student_id

            }

            override fun areContentsTheSame(
                oldItem: StudentsDetails,
                newItem: StudentsDetails
            ): Boolean {
               // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                return oldItem==newItem
            }//two list no compare chesthundi


        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecylerViewHolder {
            val view:View=LayoutInflater.from(context).inflate(R.layout.row,parent,false)

            return RecylerViewHolder(view)
        }
/*
        override fun getItemCount(): Int {
           // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return l.size
        }*/

        override fun onBindViewHolder(holder: RecylerViewHolder, position: Int) {
         //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            val l=getItem(position)
            /*holder.student_id.text=(l.get(position).student_id).toString()
            holder.student_name.text=l.get(position).student_name
            holder.student_age.text=(l.get(position).student_age).toString()
            */
            holder.student_id.text=(l.student_id).toString()
            holder.student_name.text=l.student_name
            holder.student_age.text=(l.student_age).toString()

        }

    }
    class RecylerViewHolder(itemView :View):RecyclerView.ViewHolder(itemView){
        val student_id:TextView=itemView.findViewById(R.id.result_id)
        val student_name:TextView=itemView.findViewById(R.id.result_name)
        val student_age:TextView=itemView.findViewById(R.id.result_age)

    }
}
