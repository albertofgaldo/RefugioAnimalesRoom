package com.animal.refugio.refugioanimales.persistance;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnection {

    Context context;
    SQLiteDatabase database;
    DBHelper dbHelper;

    public DBConnection(Context context){
        this.context = context;
        dbHelper = new DBHelper(this.context);
        database = dbHelper.getWritableDatabase();
        //dbHelper.onCreate(database);
    }

    public void open(){
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        database.close();
    }

    public void insert(String tableName, ContentValues contentValues){
        long newRowId = database.insert(tableName,null,contentValues);
    }
}
