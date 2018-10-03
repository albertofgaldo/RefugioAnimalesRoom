package com.animal.refugio.refugioanimales.persistance;

import android.content.ClipData;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.animal.refugio.refugioanimales.application.Controller.AnimalController;

public class BBDD_Structure extends SQLiteOpenHelper {

    public static final String DB_FILE_NAME = "animal_shelter.db";
    public static final int  DB_VERSION = 1;

    //final String CREAR_TABLA_ANIMAL = "CREATE TABLE animal (id INTEGER, nombre STRING, age INTEGER, hasChip BOOLEAN, kind STRING, registerDate DATE, picture BITMAP)";

    public BBDD_Structure(Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION);
    }

    //creamos los scripts
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ItemsTable.SQL_CREATE);
    }

    //refrescamos los scripts
    @Override
    public void onUpgrade(SQLiteDatabase db, int verisonAntigua, int verisonNueva) {
        db.execSQL(ItemsTable.SQL_DELETE);
        onCreate(db);
    }
}
