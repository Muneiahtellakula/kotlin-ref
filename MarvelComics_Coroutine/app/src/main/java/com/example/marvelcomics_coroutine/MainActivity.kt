package com.example.marvelcomics_coroutine

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
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
    val BASE_URL: String =
        "https://gateway.marvel.com/v1/public/characters?ts=1&apikey=9cc1a6a0723c43b6347867f74090e07c&hash=ee3212adb6ff845ae493ad08b592cdc0"
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iv=findViewById(R.id.img)
        tv = findViewById(R.id.textView)
        tv_dec=findViewById(R.id.dec)
        btn = findViewById(R.id.button)
        progressBar = findViewById(R.id.pb)
        progressBar.visibility = View.GONE

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
        val path_plus_exten:String=path+"."+exten
        Log.i("imgurl",path_plus_exten)
        tv_dec.text=descrtiption
        //Glide.with(this).load(path_plus_exten).into(iv)
            Glide.with(this)
        tv.text = name


    }

}
