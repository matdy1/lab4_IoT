package com.example.lab4;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.lab4.Services.CityService;
import com.example.lab4.adapter.CityAdapter;
import com.example.lab4.databinding.FragmentGeoBinding;
import com.example.lab4.entity.City;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppActivity extends AppCompatActivity{

    FragmentGeoBinding binding;
    CityService cityService;
    private String appid="8dd6fc3be19ceb8601c2c3e811c16cf1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_geo);

        binding = FragmentGeoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cityService = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CityService.class);


        binding.buscarGeo.setOnClickListener(view -> {
                String geolo = binding.geolo.getText().toString();
                cityService.getCity(geolo,1,appid).enqueue(new Callback<List<City>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<City>> call, @NonNull Response<List<City>> response) {
                        if (response.isSuccessful()) {
                            List<City> city = response.body();
                            CityAdapter adapter = new CityAdapter();
                            adapter.setContext(AppActivity.this);
                            adapter.setListSites(city);

                            binding.recyclerView.setAdapter(adapter);
                            binding.recyclerView.setLayoutManager(new LinearLayoutManager(AppActivity.this));

                        } else {
                            Log.d("AppActivity", "Response not successful or body is null");
                        }

                    }
                    @Override
                    public void onFailure(@NonNull Call<List<City>> call, @NonNull Throwable t) {
                        t.printStackTrace();
                    }
                });
        });
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


}