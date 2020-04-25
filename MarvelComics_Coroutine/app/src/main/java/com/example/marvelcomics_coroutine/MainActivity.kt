package com.example.marvelcomics_coroutine

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
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
    lateinit var tv: TextView
    lateinit var tv_dec: TextView
    lateinit var btn: Button
    lateinit var iv:ImageView
    val int = 100;
    val BASE_URL: String =
        "https://gateway.marvel.com/v1/public/characters?ts=1&apikey=9cc1a6a0723c43b6347867f74090e07c&hash=ee3212adb6ff845ae493ad08b592cdc0"
    lateinit var progressBar: ProgressBar
    lateinit var mainModelView: MainModelView
    var  dataList:List<DataList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iv=findViewById(R.id.img)
        tv = findViewById(R.id.textView)
        tv_dec=findViewById(R.id.dec)
        btn = findViewById(R.id.button)
        progressBar = findViewById(R.id.pb)
        progressBar.visibility = View.GONE
dataList=List<DataList>()
        mainModelView= ViewModelProvider(this).get(MainModelView::class.java)
        mainModelView.data.observe(this, Observer {
            tv.text=mainModelView.data.value.toString()
            tv_dec.text=mainModelView.data.value.toString()
           })
        // binding.textView.text=maninViewModel.count.value.toString()

        btn.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            CoroutineScope(Dispatchers.IO).launch {
                fetchData()
            }
        }


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
        progressBar.visibility = View.GONE
        val rootObj: JSONObject = JSONObject(text)
        val data: JSONObject = rootObj.getJSONObject("data")
        val results: JSONArray = data.getJSONArray("results")
        val resultsobj: JSONObject = results.getJSONObject(1)
        val name: String = resultsobj.getString("name")
        val descrtiption: String = resultsobj.getString("description")
        val thumbnail: JSONObject = resultsobj.getJSONObject("thumbnail")
        val path:String=thumbnail.getString("path")
        val exten:String=thumbnail.getString("extension")
        val path_plus_exten:String=path+"."+exten.toString()
        Log.i("imgurl",path_plus_exten)
        val img="https://s3.amazonaws.com/appsdeveloperblog/Micky.jpg"

        tv_dec.text=descrtiption
        //Glide.with(this).load(").into(iv)
        Glide.with(this).
                load(img)
            //load("http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.jpg")
            .into(iv)
       // Picasso.get().load(path_plus_exten).placeholder(R.mipmap.ic_launcher).into(iv)
        tv.text = name


    }
    private fun displayData(list: List<DataList>) {
            tv=mainModelView.data.value.toString()
    }

}
