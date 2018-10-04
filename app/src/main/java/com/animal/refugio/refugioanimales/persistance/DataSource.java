package com.animal.refugio.refugioanimales.persistance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataSource {

    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;

    public DataSource(Context context){
        this.mContext = context;
        mDbHelper = new DBHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();
        mDbHelper.onCreate(mDatabase);

    }

    public void open(){
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close(){
        mDatabase.close();
    }
}
