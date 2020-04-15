package com.example.newexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newexample.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
lateinit var binding:ActivityMainBinding
   lateinit var maninViewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        maninViewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        /*for data binding */
        binding.mvmVar=maninViewModel

            binding.setLifecycleOwner(this)
        //for eliminating bipracate code  using observers
       /* maninViewModel.count.observe(this, Observer { binding.textView.text=maninViewModel.count.value.toString() })*/
       // binding.textView.text=maninViewModel.count.value.toString()
        Timber.i("We are on Oncreate()")
       /* binding.button.setOnClickListener {
          //  maninViewModel.count++
            maninViewModel.increament()
           // binding.textView.text=maninViewModel.count.toString()
          //  binding.textView.text=maninViewModel.count.value.toString()
        }
        binding.button2.setOnClickListener {
           // maninViewModel.count--
            maninViewModel.decreament()
           // binding.textView.text=maninViewModel.count.toString()
          //  binding.textView.text=maninViewModel.count.value.toString()
        }*/
    }
}
