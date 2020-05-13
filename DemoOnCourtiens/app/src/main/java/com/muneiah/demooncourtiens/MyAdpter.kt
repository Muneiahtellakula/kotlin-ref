package com.muneiah.demooncourtiens

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdpter(
    mainActivity: MainActivity,
    list: MutableList<Details>
) : RecyclerView.Adapter<MyAdpter.MyViewHolder>() {
    lateinit var list:MutableList<Details>
    var context=mainActivity
    var list1=list
    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var contry_name: TextView = v.findViewById(R.id.textView_count_name)
        var contry_deats: TextView = v.findViewById(R.id.textViewDeath)
        var contry_todayDeath: TextView = v.findViewById(R.id.textView_todaydeath)
        var contry_cases: TextView = v.findViewById(R.id.cases_tv)
        var contry_todaycases: TextView = v.findViewById(R.id.textView_todayCaes)
        var contry_active: TextView = v.findViewById(R.id.textView_ative)
        var contry_todayActive: TextView = v.findViewById(R.id.textView_activetoday)
        var contry_recovered: TextView = v.findViewById(R.id.textView_recovered)
        var contry_critical: TextView = v.findViewById(R.id.textView_critical)
        var contry_Flag: ImageView = v.findViewById(R.id.imageView_flag)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.rowdesign, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val l=list1.get(position)
        Picasso.get().load(l.flag).into(holder.contry_Flag)
        holder.contry_active.text=l.active
        holder.contry_name.text=l.countryName
        holder.contry_critical.text=l.critical
        holder.contry_deats.text=l.deaths
        holder.contry_todayDeath.text=l.todayDeaths
        holder.contry_todayActive.text=l.todaycases
        holder.contry_cases.text=l.cases
        holder.contry_recovered.text=l.recovered
        holder.contry_todaycases.text=l.todaycases

    }

}