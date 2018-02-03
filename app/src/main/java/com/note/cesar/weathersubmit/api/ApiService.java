package com.note.cesar.weathersubmit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shekh on 03-02-2018.
 */

public class ApiService {

    private ApiService(){}

    private static APIInterface apiInterface = null;

    public static APIInterface getApiInterface(){
        if(apiInterface == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://dataservice.accuweather.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return apiInterface;
    }

}
