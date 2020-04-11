package com.muni.navigationcomponets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
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
        val v:View= inflater.inflate(R.layout.fragment_home, container, false)
       val rb:Button =v.findViewById(R.id.red)
       val bb:Button =v.findViewById(R.id.blue)
       val gb:Button =v.findViewById(R.id.green)
        rb.setOnClickListener { it.findNavController().navigate(R.id.redFragment) }
        gb.setOnClickListener { it.findNavController().navigate(R.id.greenFragment) }
        bb.setOnClickListener { it.findNavController().navigate(R.id.blueFragment) }
        return v
    }

   /* override fun passDataCom(editext_input: String) {
        val bundle = Bundle()
        bundle.putString("input_txt",editext_input)

        val transaction = this.supportFragmentManager.beginTransaction()
        val redFrag = RedFragment()
        redFrag.arguments = bundle
        transaction.replace(R.id.content_id, redFrag)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }*/
}
