package com.note.cesar.weathersubmit.models;

/**
 * Created by shekh on 03-02-2018.
 */

public class Country {

    String ID, EnglishName;

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setEnglishName(String englishName) {
        EnglishName = englishName;
    }

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
