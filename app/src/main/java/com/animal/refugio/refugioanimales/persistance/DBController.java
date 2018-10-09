package com.animal.refugio.refugioanimales.persistance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class DBController {

    DBConnection dbConnection;

    public DBController(Context context){
        dbConnection = new DBConnection(context);
        dbConnection.open();
    }

    public void openConnection(){
        dbConnection.open();
    }

    public void readConnection() { dbConnection.read(); }

    public void closeConnection(){
        dbConnection.close();
    }

    public void insertValues(EditText nameText, EditText ageText, CheckBox hasChip, EditText dateText, EditText typeText, byte[] image){
        ContentValues values = mapFields(nameText, ageText, hasChip, dateText, typeText, image);
        dbConnection.insert(DBStructure.TABLE_NAME, values);
    }

    public ContentValues mapFields(EditText nameText, EditText ageText, CheckBox hasChip, EditText dateText, EditText typeText, byte[] image){
        ContentValues values = new ContentValues();

        //values.put(DBStructure.COLUMN_ID,);
        values.put(DBStructure.COLUMN_NAME,nameText.getText().toString());
        values.put(DBStructure.COLUMN_AGE,ageText.getText().toString());
        values.put(DBStructure.COLUMN_CHIP,hasChip.isChecked());
        values.put(DBStructure.COLUMN_DATE,dateText.getText().toString());
        values.put(DBStructure.COLUMN_TYPE, typeText.getText().toString());
        values.put(DBStructure.COLUMN_IMAGE, image);

        return values;
    }

    public ArrayList<ContentValues> createQuery(){
        //Selecionar columnas
        String [] projection = {
                DBStructure.COLUMN_NAME,
                DBStructure.COLUMN_AGE,
                DBStructure.COLUMN_CHIP,
                DBStructure.COLUMN_DATE,
                DBStructure.COLUMN_TYPE,
                DBStructure.COLUMN_IMAGE
        };
        //Seleccionar where
        String selection = "";
        String[] selectionArgs = {""};

        //Ordenar búsqueda
        String sortOrder =
                DBStructure.COLUMN_DATE + " DESC";

        return createCursor(projection,selection,selectionArgs,sortOrder);
    }

    public ArrayList<ContentValues> createCursor(String [] projection, String selection, String [] selectionArgs, String sortOrder){
        Cursor c = dbConnection.database.query(
                DBStructure.TABLE_NAME,
                projection,
                null,
                null,
                null,           //agrupar registros
                null,           //agrupar por filas
                sortOrder
        );
        c.moveToFirst();
        return queryToList(c);
    }

    public ArrayList<ContentValues> queryToList(Cursor cursor){

        ArrayList <ContentValues> animales = new ArrayList<>();

        for(int i=0; i<=cursor.getCount();i++){
           animales.add(mapResult(cursor));
           cursor.moveToNext();
        }
        return animales;
    }

    public ContentValues mapResult(Cursor c){
        ContentValues values = new ContentValues();

        values.put(DBStructure.COLUMN_NAME,c.getColumnIndex(DBStructure.COLUMN_NAME));
        values.put(DBStructure.COLUMN_AGE,c.getColumnIndex(DBStructure.COLUMN_AGE));
        values.put(DBStructure.COLUMN_CHIP,c.getColumnIndex(DBStructure.COLUMN_CHIP));
        values.put(DBStructure.COLUMN_DATE,c.getColumnIndex(DBStructure.COLUMN_DATE));
        values.put(DBStructure.COLUMN_TYPE, c.getColumnIndex(DBStructure.COLUMN_TYPE));
        values.put(DBStructure.COLUMN_IMAGE, c.getColumnIndex(DBStructure.COLUMN_IMAGE));

        return values;
    }


}
