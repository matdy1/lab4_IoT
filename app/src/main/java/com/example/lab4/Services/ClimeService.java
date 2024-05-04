package com.example.lab4.Services;

import com.example.lab4.entity.City;
import com.example.lab4.entity.Clime;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ClimeService {

    //?lat=12&lon=13&appid=792edf06f1f5ebcaf43632b55d8b03fe
    @GET("/data/2.5/weather")
    Call<Clime> getCity(@Query("lat") double q,
                              @Query("lon") double limit,
                              @Query("appid") String appid);
}
