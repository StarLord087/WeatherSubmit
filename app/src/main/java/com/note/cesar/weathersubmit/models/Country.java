package com.note.cesar.weathersubmit.models;

/**
 * Created by shekh on 03-02-2018.
 */

public class Country {

    String ID, EnglishName;

    public String getID() {
        return ID;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public Country(String ID, String englishName) {

        this.ID = ID;
        EnglishName = englishName;
    }
}
