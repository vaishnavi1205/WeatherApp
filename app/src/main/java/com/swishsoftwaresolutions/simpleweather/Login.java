package com.swishsoftwaresolutions.simpleweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Login extends AppCompatActivity {
    Spinner spin;
    Button get,fav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        spin = (Spinner)findViewById(R.id.spinner);
        get = (Button)findViewById(R.id.go);
        fav = (Button)findViewById(R.id.fav_login);

        ArrayAdapter adapter= ArrayAdapter.createFromResource(Login.this,R.array.city,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city_name = spin.getSelectedItem().toString();
                Log.e("Name:",city_name);
                new CityPreference(Login.this).setCity(city_name);
                Intent intent = new Intent(Login.this,WeatherActivity.class);
                startActivity(intent);
            }
        });

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fav_intent = new Intent(Login.this,Favorites.class);
                startActivity(fav_intent);
            }
        });


    }
}
