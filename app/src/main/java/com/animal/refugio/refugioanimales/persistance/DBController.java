package com.animal.refugio.refugioanimales.persistance;

import android.content.ContentValues;
import android.content.Context;
import android.widget.CheckBox;
import android.widget.EditText;

public class DBController {

    DBConnection dbConnection;

    public DBController(Context context){
        dbConnection = new DBConnection(context);
        dbConnection.open();
    }

    public void openConnection(){
        dbConnection.open();
    }

    public void closeConnection(){
        dbConnection.close();
    }

    public void insertValues(EditText nameText, EditText ageText, CheckBox hasChip, EditText dateText, EditText typeText, byte[] image){
        ContentValues values = mapFields(nameText, ageText, hasChip, dateText, typeText, image);
        dbConnection.insert(DBStructure.TABLE_NAME, values);
    }

    public ContentValues mapFields(EditText nameText, EditText ageText, CheckBox hasChip, EditText dateText, EditText typeText, byte[] image){
        ContentValues values = new ContentValues();

        values.put(DBStructure.COLUMN_NAME,nameText.getText().toString());
        values.put(DBStructure.COLUMN_AGE,ageText.getText().toString());
        values.put(DBStructure.COLUMN_CHIP,hasChip.isChecked());
        values.put(DBStructure.COLUMN_DATE,dateText.getText().toString());
        values.put(DBStructure.COLUMN_TYPE, typeText.getText().toString());
        values.put(DBStructure.COLUMN_IMAGE, image);

        return values;
    }
}
