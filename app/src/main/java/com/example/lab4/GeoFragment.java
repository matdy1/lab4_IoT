package com.example.lab4;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab4.Services.CityService;
import com.example.lab4.databinding.FragmentClimeBinding;
import com.example.lab4.databinding.FragmentGeoBinding;
import com.example.lab4.entity.City;
import com.example.lab4.entity.CityDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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