package com.example.lab4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab4.databinding.FragmentClimeBinding;


public class ClimeFragment extends Fragment {

    FragmentClimeBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentClimeBinding.inflate(inflater,container,false);
        NavController navController = NavHostFragment.findNavController(ClimeFragment.this);
        binding.geolocalizacion.setOnClickListener( view -> {
            navController.navigate(R.id.action_climeFragment_to_geoFragment);
        });

        
        return binding.getRoot();
    }

}