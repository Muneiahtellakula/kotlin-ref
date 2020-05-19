package com.muneiah.navigationcomponentsjava;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        Button red=view.findViewById(R.id.redbtn);
        Button blue=view.findViewById(R.id.bluebtn);
        Button green=view.findViewById(R.id.greenbtn);
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NavController navController = Navigation.findNavController(v);
                //navController.popBackStack();
                navController.navigate(R.id.action_homeFragment_to_redFragment);
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NavController navController = Navigation.findNavController(v);
                //navController.popBackStack();
                navController.navigate(R.id.action_homeFragment_to_blueFragment);
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NavController navController = Navigation.findNavController(v);
                //navController.popBackStack();
                navController.navigate(R.id.action_homeFragment_to_greenFragment);
            }
        });
        return view;
    }
}
