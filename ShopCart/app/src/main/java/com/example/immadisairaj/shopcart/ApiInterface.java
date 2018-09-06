package com.example.immadisairaj.shopcart;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL = "https://bitnami-39xfosdmxa.appspot.com/";

    @GET("get-items")
    Call<List<Phone>> getPhone();

    @GET("get-items")
    Call<List<Phone>> getPhone(
            @Query("manufacturer") String manufacturer,
            @Query("model") String model,
            @Query("min-price") Integer minPrice,
            @Query("max-price") Integer maxPrice
    );

}
