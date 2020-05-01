package com.muneiah.navigationcomponentdemo

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
        val v= inflater.inflate(R.layout.fragment_home, container, false)
        val first_btn=v.findViewById<Button>(R.id.first)
        val scond_btn=v.findViewById<Button>(R.id.scond)
        val third_btn=v.findViewById<Button>(R.id.third)
        first_btn.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_firstFragment)
        }
        scond_btn.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment)
        }
        third_btn.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_thirdFragment)
        }

        return v
    }

}
