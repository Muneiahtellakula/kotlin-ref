package com.muni.navigationcomponets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_red.view.*

/**
 * A simple [Fragment] subclass.
 */
class RedFragment : Fragment() {
    var inputText: String? = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_red, container, false)
        val rootView = inflater.inflate(R.layout.fragment_red, container, false)
        inputText = arguments?.getString("input_txt")

        rootView.output_textview.text = inputText

        return rootView

    }

}
