package com.animal.refugio.refugioanimales.application.Controller;

import android.content.ContentValues;
import android.content.Context;

import com.animal.refugio.refugioanimales.persistance.DataSource;

public class AnimalController {

    DataSource mDataSource;

    public AnimalController(Context context){
        mDataSource = new DataSource(context);
        mDataSource.open();
    }

    public void openDataSource(){
        mDataSource.open();
    }

    public void closeDataSource(){
        mDataSource.close();
    }

  //crear funciones insert
    public void createAnimal(ContentValues contentValues){
        contentValues
    }

}
