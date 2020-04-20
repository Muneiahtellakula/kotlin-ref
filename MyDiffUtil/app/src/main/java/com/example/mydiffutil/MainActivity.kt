package com.example.mydiffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var list : MutableList<Employee>
    lateinit var adapter : Employee_adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        populateData()
    }

    private fun populateData() {
        list= mutableListOf(Employee(1,"muni"), Employee(2,"sai"))
        adapter= Employee_adapter(this)
        adapter.submitList(list)
        recyclerView.adapter=adapter
    }


    fun update(view: View) {
        list.set(0,Employee(1,"muneiah"))
        recyclerView.adapter=adapter

    }
}
