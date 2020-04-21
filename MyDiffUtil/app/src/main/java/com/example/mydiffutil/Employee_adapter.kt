package com.example.mydiffutil

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class Employee_adapter(val context: Context) :
    ListAdapter<Employee, EmployeViewHolder>(EmployeeDiffUtil()) {

    class EmployeeDiffUtil : DiffUtil.ItemCallback<Employee>() {
        override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return oldItem.emp_id == newItem.emp_id
        }

        override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeViewHolder {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        // return EmployeViewHolder(LayoutInflater.from(context).inflate(R.layout.row_design,parent,false))
        return EmployeViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.row_design,
                parent,
                false
            )
        )
    }

    /* before diffUtil
    override fun getItemCount(): Int {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return list.size

     }*/

    override fun onBindViewHolder(holder: EmployeViewHolder, position: Int) {
        //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val list = getItem(position)
        holder.emp_id_tv.text = (list.emp_id).toString()
        holder.emp_name.text = (list.emp_name).toString()
    }

}

class EmployeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val emp_id_tv = itemView.findViewById<TextView>(R.id.emp_id)
    val emp_name: TextView = itemView.findViewById(R.id.emp_name)
}