package com.note.cesar.weathersubmit.models;

/**
 * Created by shekh on 03-02-2018.
 */

public class Versionone {

    String LocalizedName;
    String Key;

    public String getLocalizedName() {
        return LocalizedName;
    }

    public String getKey() {
        return Key;
    }

    public Versionone(String localizedName, String key) {

        LocalizedName = localizedName;
        Key = key;
    }
}
