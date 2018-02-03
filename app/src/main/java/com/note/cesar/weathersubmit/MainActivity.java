package com.note.cesar.weathersubmit;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.note.cesar.weathersubmit.api.ApiService;
import com.note.cesar.weathersubmit.models.Country;
import com.note.cesar.weathersubmit.models.Versionone;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MainActivity extends AppCompatActivity implements LocationListener {

    TextView tvCity, tvTemp, tvLocal, tvCountry;
    LocationManager locationManager;
    public static final String TAG = "LOC";
    public static final String API_KEY = "P6eflaANHkOikO2vBjlId8H4XcQGc3YP";

    String longitude, latitude;
    public String geolocation, key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCity = findViewById(R.id.tv_city);
        tvTemp = findViewById(R.id.tv_temp);
        tvLocal = findViewById(R.id.tv_local);
        tvCountry = findViewById(R.id.tv_country);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        if(ContextCompat.checkSelfPermission(this,ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
           ActivityCompat.requestPermissions(this,
                   new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},
                   111);
        }else {
            startLocUpates();
        }


        ApiService.getApiInterface().getKeyByGeoposition(geolocation).enqueue(new Callback<Versionone>() {
            @Override
            public void onResponse(Call<Versionone> call, Response<Versionone> response) {
                key = response.body().getKey();
            }

            @Override
            public void onFailure(Call<Versionone> call, Throwable t) {

            }
        });
        Log.d(TAG, key);
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d(TAG, "latitude = " + location.getLatitude());
        Log.d(TAG, "longitude = " + location.getLongitude());
        Log.d(TAG, " = = = = = = = = = = = = = = =  ");

        longitude = ""+ location.getLongitude();
        latitude = "" + location.getLatitude();

        geolocation = latitude+","+longitude;

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }


    @SuppressLint("MissingPermission")
    public void startLocUpates(){
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1000,100f,this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 111) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                startLocUpates();
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
