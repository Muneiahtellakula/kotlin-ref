package com.muneiah.navcomp

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
class HFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_h, container, false)
        val fb=view.findViewById<Button>(R.id.fst)
        val sb=view.findViewById<Button>(R.id.snd)
        fb.setOnClickListener {
            it.findNavController().navigate(R.id.action_HFragment_to_FFragment)
        }
        sb.setOnClickListener {
            it.findNavController().navigate(R.id.action_HFragment_to_SFragment)
            
        }
        return view
    }

}
