package com.muneiah.mynavcomponentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_home,container,false)
            val  ob=view.findViewById<Button>(R.id.frst)
            val  tb=view.findViewById<Button>(R.id.scnd)
            val  ttb=view.findViewById<Button>(R.id.trd)
        ob.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_oneFragment)
        }
        tb.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_twoFragment)
        }
        ttb.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_threeFragment)
        }
        return view
    }



}
