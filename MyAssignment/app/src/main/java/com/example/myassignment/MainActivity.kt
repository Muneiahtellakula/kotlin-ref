package com.example.myassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var databinding: ActivityMainBinding
   // var list = mutableListOf<String>()
   //var index = 0
    lateinit var mainviewmodel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        /*  list= mutableListOf("Apple","Banana")
           for (i in list){
               databinding.tvList.append(i+" ")
           }*/

        mainviewmodel = ViewModelProvider(this).get(MainViewModel::class.java)
        databinding.myvar=mainviewmodel

        mainviewmodel.word.observe(this, Observer {
            databinding.tvList.text = mainviewmodel.word_list.value
        })
        mainviewmodel.word.observe(this, Observer {
            databinding.wordDisply.text = mainviewmodel.word.value
        })


       /* databinding.button.setOnClickListener {
            mainviewmodel.updateList()
        }
        databinding.nextBtn.setOnClickListener {
            mainviewmodel.nextWord()
        }
        databinding.prevBtn.setOnClickListener {
            mainviewmodel.prevWord()
        }*/

    }


}
