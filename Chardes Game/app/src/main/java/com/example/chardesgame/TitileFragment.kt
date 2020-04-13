package com.example.chardesgame

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
class TitileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View= inflater.inflate(R.layout.fragment_titile, container, false)
        val btn_playing=v.findViewById<Button>(R.id.playbtn)
        btn_playing.setOnClickListener {
           // v.findNavController.navigate(R.id.action_titileFragment_to_gameFragment)
            v.findNavController().navigate(R.id.action_titileFragment_to_gameFragment)
        }
        return v
    }

}
