package com.muneiah.demooncourtiens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    val Base_Url="https://corona.lmao.ninja/v2/countries"
    lateinit var adaper:MyAdpter
   lateinit var list:MutableList<Details>

    lateinit var tvt:TextView
    lateinit var rv:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // tvt=findViewById(R.id.tv)
rv=findViewById(R.id.rec)
    }

    fun getData(view: View) {


        CoroutineScope(Dispatchers.IO).launch {
            getApiData(Base_Url)
        }

    }
    suspend fun getApiData(baseUrl: String) {
        val api=URL(baseUrl)
        val http:HttpURLConnection= api.openConnection() as HttpURLConnection
        val int:InputStream=http.inputStream
        val data=int.bufferedReader().use(BufferedReader::readText)
        withContext(Dispatchers.Main){
            setValueOnResult(data)
        }
      //  Toast.makeText(this,data,Toast.LENGTH_SHORT).show()
       // withContext(Dispatchers.Main)
    }

    private fun setValueOnResult(data: String){
      //  progress.visibility=View.GONE
      //  tvt.text=data
        val rootAry=JSONArray(data)
        for (i in 0..rootAry.length()-1)
        {
            val jsonObj = rootAry.getJSONObject(i)
            val countryName = jsonObj.getString("country")
            val cases=jsonObj.getString("cases")
            val todaycases=jsonObj.getString("todayCases")
            val deaths=jsonObj.getString("deaths")
            val todayDeaths=jsonObj.getString("todayDeaths")
            val active=jsonObj.getString("active")
            val recovered=jsonObj.getString("recovered")
            val critical=jsonObj.getString("critical")
            val countryInfo=jsonObj.getJSONObject("countryInfo")
            val flg=countryInfo.getString("flag")
            list= mutableListOf(Details(countryName,cases,todaycases,deaths,todayDeaths,active,recovered,critical,flg))
            adaper=MyAdpter(this,list)
            rv.adapter=adaper
            rv.layoutManager=LinearLayoutManager(this)

        }

        //tvt.text=countryName

    }
}
