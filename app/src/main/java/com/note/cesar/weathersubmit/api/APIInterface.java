package com.note.cesar.weathersubmit.api;

import com.note.cesar.weathersubmit.models.AccuWeatherModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by shekh on 03-02-2018.
 */

public interface APIInterface {


    @GET("currentconditions/v1/{key}")
    Call<AccuWeatherModel> getAccuWeatherData(@Path("key") String cityKey, @Query("apikey") String appId);

    @GET("/locations/v1/cities/geoposition/search")
    Call<AccuWeatherModel> getKeyByGeoposition(@Query("apikey") String appId, @Query("q") String query);



}
