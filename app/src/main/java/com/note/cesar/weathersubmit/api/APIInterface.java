package com.note.cesar.weathersubmit.api;

import com.note.cesar.weathersubmit.models.Country;
import com.note.cesar.weathersubmit.models.Versionone;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by shekh on 03-02-2018.
 */

public interface APIInterface {


    @GET("/currentconditions/v1/{Key}?apikey=P6eflaANHkOikO2vBjlId8H4XcQGc3YP HTTP/1.1")
    Call<Versionone> getTempByKey(@Path("Key") String Key);

    @GET("/locations/v1/cities/{geoposition}/search?apikey=P6eflaANHkOikO2vBjlId8H4XcQGc3YP&q=28.74210649%2C77.1164629\"")
    Call<Versionone> getKeyByGeoposition(@Path("geoposition") String geoposition);

}
