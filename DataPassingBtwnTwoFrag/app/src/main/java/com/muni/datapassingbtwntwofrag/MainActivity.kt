package com.muni.datapassingbtwntwofrag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(),Communicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Set replace Main Activity content with the Fragment1 content
        val Fragment1 = FirstFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, Fragment1).commit()

    }

    override fun passDataCom(editext_input: String) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val bundle = Bundle()
        bundle.putString("input_txt",editext_input)

        val transaction = this.supportFragmentManager.beginTransaction()
        val frag2 = SecondFragment()
        frag2.arguments = bundle

        transaction.replace(R.id.container, frag2)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }
}
