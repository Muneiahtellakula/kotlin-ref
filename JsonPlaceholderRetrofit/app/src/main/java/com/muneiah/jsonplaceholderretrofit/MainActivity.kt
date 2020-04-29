package com.muneiah.jsonplaceholderretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(), Callback<List<Post>> {
lateinit var tv:TextView
    lateinit var post_btn:Button
    lateinit var get_btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       post_btn=findViewById(R.id.button_post)
        val okhttp=OkHttpClient.Builder()
            .connectTimeout(1,TimeUnit.MINUTES)
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .build()
        get_btn=findViewById(R.id.button_get)
        tv=findViewById(R.id.respons)
        val moshi=Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val retrofit=Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okhttp)
            .build()
        val jsonPlaceHoldserService: JsonPlaceHoldserService = retrofit.create(JsonPlaceHoldserService::class.java)
       get_btn.setOnClickListener {
           CoroutineScope(Dispatchers.IO).launch {
               jsonPlaceHoldserService.getAllValues().enqueue(object :Callback<Post>{

               })
           }

       }
        post_btn.setOnClickListener {
            val post=Post(body = "my body",title = "my titile")
            jsonPlaceHoldserService.postValue(Post()).enqueue(object :Callback<Post>{
                override fun onFailure(call: Call<Post>, t: Throwable) {
                    Log.i("MainActivity","faild")

                }

                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    Toast.makeText(this@MainActivity,"success",Toast.LENGTH_SHORT).show()
                    tv.text=""
                    val post=response.body()
                    tv.append(" "+response.code()+"\n"+post?.id+"\n"+
                    post?.body+"\n"+post?.title)
                }

            })
        }


    }

    override fun onFailure(call: Call<List<Post>>, t: Throwable) {
        Log.i("MainActivity",t.message)
    }

    override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
    Toast.makeText(this,"success",Toast.LENGTH_SHORT).show()
        tv.text = ""
        if (response.isSuccessful) {
            val list = response.body()
            for (i in list!!) {
                tv.append(i.title +i.body+ "\n\n")
            }
        }
    }
}
