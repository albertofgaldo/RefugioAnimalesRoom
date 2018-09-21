package com.animal.refugio.refugioanimales.persistance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.animal.refugio.refugioanimales.application.Controller.AnimalController;

public class BBDD_Structure extends SQLiteOpenHelper {

    final String CREAR_TABLA_ANIMAL = "CREATE TABLE animal (id INTEGER, nombre STRING, age INTEGER, hasChip BOOLEAN, kind STRING, registerDate DATE, picture BITMAP)";

    public BBDD_Structure(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //creamos los scripts
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREAR_TABLA_ANIMAL);

    }

    //refrescamos los scripts
    @Override
    public void onUpgrade(SQLiteDatabase db, int verisonAntigua, int verisonNueva) {

        db.execSQL("DROP TABLE IF EXISTS animal");
        onCreate(db);

    }
}
