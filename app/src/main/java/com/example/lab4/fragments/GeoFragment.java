package com.example.lab4.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab4.R;

public class GeoFragment extends Fragment {

    FragmentGeoBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentGeoBinding.inflate(inflater,container,false);

        NavController navController = NavHostFragment.findNavController(GeoFragment.this);
        binding.clima.setOnClickListener( view -> {
            navController.navigate(R.id.action_geoFragment_to_climeFragment);
        });
        return binding.getRoot();
    }





}