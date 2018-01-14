package com.swishsoftwaresolutions.simpleweather;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Favorites extends AppCompatActivity {
    ListView listView;
    ArrayList<ModuleClass> moduleClass;
    SQLite database;
    TextView city,update,details,temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        listView = (ListView)findViewById(R.id.clv);
        database = new SQLite(Favorites.this);
        moduleClass = database.retriveData();
        final CustomAdapter adapter = new CustomAdapter(Favorites.this,0);
        listView.setAdapter(adapter);
    }

    class CustomAdapter extends ArrayAdapter {
        public CustomAdapter(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public int getCount() {

            return moduleClass.size();
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null){
                LayoutInflater inflater = LayoutInflater.from(Favorites.this);
                convertView = inflater.inflate(R.layout.custom_list,null);
                city = (TextView) convertView.findViewById(R.id.text1);
                update = (TextView) convertView.findViewById(R.id.text2);
                details = (TextView) convertView.findViewById(R.id.text3);
                temp = (TextView) convertView.findViewById(R.id.text4);


            }
            city.setText(moduleClass.get(position).getCity());
            update.setText(moduleClass.get(position).getUpdated_details());
            details.setText(moduleClass.get(position).getDetails());
            temp.setText(moduleClass.get(position).getTemperature());

            return convertView;
        }


    }
}
