package com.muneiah.androidviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.muneiah.androidviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var textLabel:TextView
var c=0
    lateinit var databinding:ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       databinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        textLabel=findViewById(R.id.tv)
        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)
      //  textLabel.text=mainViewModel.c.toString()
        databinding.myvar=mainViewModel

        databinding.setLifecycleOwner(this)

    }


    fun showtoast(view: View) {
        Toast.makeText(this
        ,"count is :"+textLabel.text.toString(),Toast.LENGTH_SHORT).show()
    }
}
