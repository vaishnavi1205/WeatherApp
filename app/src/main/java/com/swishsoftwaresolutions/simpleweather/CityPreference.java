package com.swishsoftwaresolutions.simpleweather;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by DELL on 1/13/2018.
 */

public class CityPreference {
    SharedPreferences prefs;

    public CityPreference(Activity activity){
        prefs = activity.getSharedPreferences("myPref",Activity.MODE_PRIVATE);
    }

    // If the user has not chosen a city yet, return
    // Bangalore as the default city
    String getCity(){
        return prefs.getString("city", "Bangalore, IN");
    }

    void setCity(String city){
        prefs.edit().putString("city", city).commit();
        Log.e("Pref_city",city);
    }
}
