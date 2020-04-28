package com.muneiah.retrofitgithub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.muneiah.retrofitgithub.databinding.ActivityMainBinding
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity(), Callback<List<Repo>> {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val moshi=Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
      /*  val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()*/
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()

        val gitHubServices: GitHubServices = retrofit.create(GitHubServices::class.java)
        gitHubServices.listRepos("Muneiahtellakula").enqueue(this)


    }

    override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
        Toast.makeText(this, "Data fetching faild", Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
        binding.respons.text = ""
        if (response.isSuccessful) {
            val list = response.body()
            for (i in list!!) {
                binding.respons.append(i.name + "\n")
            }
        }
    }
}
