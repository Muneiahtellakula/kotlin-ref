package com.muneiah.myexamtest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.muneiah.myexamtest.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    lateinit var databinding: ActivityMainBinding
    val BASE_URL: String =
        "https://gateway.marvel.com/v1/public/characters?ts=1&apikey=9cc1a6a0723c43b6347867f74090e07c&hash=ee3212adb6ff845ae493ad08b592cdc0"

    lateinit var list: MutableList<List<ComicDataModelEntity>>
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        databinding.pb.visibility = View.GONE
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(application))
            .get(MainViewModel::class.java)

        mainViewModel.allComics.observe(this, Observer { list ->
            displayData(list)
        })
        /*val ra=RecyclerAdapter(this)
        //val ra=RecyclerAdapter(this,list)
        databinding.recycler.adapter=ra
       // ra.submitList(list)
        databinding.recycler.adapter*/
        databinding.button.setOnClickListener {
            databinding.pb.visibility = View.VISIBLE
            CoroutineScope(Dispatchers.IO).launch {
                fetchData()
            }
        }

    }

    private fun displayData(list: List<ComicDataModelEntity>?) {
        databinding.button.visibility=View.GONE
        val ra = RecyclerAdapter(this)
        //val ra=RecyclerAdapter(this,list)
        databinding.recycler.adapter = ra
        ra.submitList(list)

    }

    private suspend fun fetchData() {


        val url = URL(BASE_URL)
        val httpconn: HttpURLConnection = url.openConnection() as HttpURLConnection
        val input_stream: InputStream = httpconn.inputStream
        val text = input_stream.bufferedReader().use(BufferedReader::readText)
        withContext(Dispatchers.Main) {
            setValueOnResult(text)
        }

    }

    private fun setValueOnResult(text: String) {
        databinding.pb.visibility = View.GONE
        //Toast.makeText(this, "Data"+text, Toast.LENGTH_SHORT).show()
        val rootObj: JSONObject = JSONObject(text)
        val data: JSONObject = rootObj.getJSONObject("data")
        val results: JSONArray = data.getJSONArray("results")
        val resultsobj: JSONObject = results.getJSONObject(1)
        val name: String = resultsobj.getString("name")
        val descrtiption: String = resultsobj.getString("description")
        val comicDataModelEntity: ComicDataModelEntity =
            ComicDataModelEntity(comic_name = name, comic_dec = descrtiption)

        mainViewModel.insert(comicDataModelEntity)
        Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show()
        /* val thumbnail: JSONObject = resultsobj.getJSONObject("thumbnail")
         val path:String=thumbnail.getString("path")
         val exten:String=thumbnail.getString("extension")
         val path_plus_exten:String=path+"."+exten
         Log.i("imgurl",path_plus_exten)*/
        /* databinding.tv_dec.text=descrtiption

         tv.text = name*/


    }

    class RecyclerAdapter(val context: Context) :
        ListAdapter<ComicDataModelEntity, RecylerViewHolder>(StudentDiffUtiill()) {

        class StudentDiffUtiill : DiffUtil.ItemCallback<ComicDataModelEntity>() {
            override fun areItemsTheSame(
                oldItem: ComicDataModelEntity,
                newItem: ComicDataModelEntity
            ): Boolean {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                return oldItem.comic_id == newItem.comic_id

            }

            override fun areContentsTheSame(
                oldItem: ComicDataModelEntity,
                newItem: ComicDataModelEntity
            ): Boolean {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                return oldItem == newItem
            }//two list ni compare chesthundi


        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecylerViewHolder {
            val view: View =
                LayoutInflater.from(context).inflate(R.layout.row_design, parent, false)

            return RecylerViewHolder(view)
        }
/*
        override fun getItemCount(): Int {
           // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return l.size
        }*/

        override fun onBindViewHolder(holder: RecylerViewHolder, position: Int) {
            //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            val l = getItem(position)

            holder.c_name.text = l.comic_name
            holder.c_dec.text = l.comic_dec

        }

    }

    class RecylerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val c_name: TextView = itemView.findViewById(R.id.textView)
        val c_dec: TextView = itemView.findViewById(R.id.dec)


    }

    fun submitBtn(view: View) {}


}


