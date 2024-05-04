package com.example.lab4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.lab4.Services.CityService;
import com.example.lab4.databinding.FragmentGeoBinding;
import com.example.lab4.entity.City;
import com.example.lab4.entity.CityDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppActivity extends AppCompatActivity {

    FragmentGeoBinding binding;
    CityService cityService;

    private String apikey="8dd6fc3be19ceb8601c2c3e811c16cf1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Inflar el diseño del fragmento y asignarlo al enlace de datos
        binding = FragmentGeoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buscarGeo.
        if (tengoInternet()) {
            cityService = new Retrofit.Builder()
                    .baseUrl("http://api.openweathermap.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CityService.class);
            cargarListaWebService();
        } else {
            // Mostrar mensaje de error si no hay conexión a Internet
            Toast.makeText(this, "No hay conexión a Internet", Toast.LENGTH_SHORT).show();
        }


        // Resto de tu lógica aquí
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }


    @Override
    protected void onStart() {
        super.onStart();
        cargarListaWebService();
    }



    public void cargarListaWebService() {
        cityService.getCity().enqueue(new Callback<List<City>>() {
            @Override
            public void onResponse(@NonNull Call<List<City>> call, @NonNull Response<List<City>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<City> city = response.body();
                    //User[] users = userList.getUsers();



                    CityAdapter adapter = new CityAdapter();
                    adapter.setContext(AppActivity.this);
                    adapter.setListSites(city);

                    binding.recyclerView.setAdapter(adapter);
                    binding.recyclerView.setLayoutManager(new LinearLayoutManager(AppActivity.this));

                } else {
                    Log.d("AdminUserListActivity", "Response not successful or body is null");
                }

            }

            @Override
            public void onFailure(@NonNull Call<List<City>> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public boolean tengoInternet() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}