package com.example.lab4.Services;

import com.example.lab4.entity.City;
import com.example.lab4.entity.CityDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CityService {

    // de la forma /?q={cityName}&limit=1&appid={API//key}
    @GET("/geo/1.0/direct")
    Call<List<City>> getCity(@Query("q") String q,
                                @Query("limit") int limit,
                                @Query("appid") String appid);
}
