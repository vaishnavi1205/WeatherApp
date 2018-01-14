package com.swishsoftwaresolutions.simpleweather;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by DELL on 1/13/2018.
 */

public class SQLite extends SQLiteOpenHelper{
    ModuleClass moduleClass = new ModuleClass();

    private static final String TAG = "DATABASE";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "weatherInfo";
    //column names
    private static final String TABLE_NAME = "weatherDetails";
    private static final String KEY_ID = "id";
    private static final String CITY = "city";
    private static final String UPDATED = "upated";
    private static final String DETAILS = "details";
    private static final String TEMPERATURE = "temperature";

    //queries
    private static final String CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + CITY + " TEXT," + UPDATED + " TEXT," + DETAILS + " TEXT," +
            TEMPERATURE + " TEXT" +")";

    private static final String DROP_QUERY = "DROP TABLE IF EXISTS "+TABLE_NAME;

    private static final String SELECT_QUERY = "SELECT * FROM "+TABLE_NAME;


    public SQLite(Context context) {

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(DROP_QUERY);
        onCreate(sqLiteDatabase);
    }
    //adding row to database
    public void addData(String city,String updated,String details,String temperature){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CITY,city);
        values.put(UPDATED,updated);
        values.put(DETAILS,details);
        values.put(TEMPERATURE,temperature);

        db.insert(TABLE_NAME,null,values);
        db.close();
        Log.i(TAG, "Data Inserted");
    }

    public ArrayList<ModuleClass> retriveData(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<ModuleClass> arrayList = new ArrayList<>();
        Cursor cursor = db.rawQuery(SELECT_QUERY,null);
        if(cursor.moveToFirst()){
            for(int i = 0;i<cursor.getCount();i++){
                moduleClass = new ModuleClass();
                moduleClass.id = Integer.parseInt(cursor.getString(0));
                moduleClass.city = cursor.getString(1);
                moduleClass.updated_details = cursor.getString(2);
                moduleClass.details = cursor.getString(3);
                moduleClass.temperature = cursor.getString(4);
                arrayList.add(moduleClass);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return arrayList;
    }
}
