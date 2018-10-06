package com.animal.refugio.refugioanimales.application.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.animal.refugio.refugioanimales.persistance.DBStructure;
import com.animal.refugio.refugioanimales.persistance.DBConnection;
//import com.squareup.picasso.Picasso;

public class AnimalController {

    DBConnection dbConnection;

    public AnimalController(Context context){
        dbConnection = new DBConnection(context);
        dbConnection.open();
    }

    public void openConnection(){
        dbConnection.open();
    }

    public void closeConnection(){
        dbConnection.close();
    }

  //crear funciones insert

    public ContentValues mapFields(EditText nameText, EditText ageText, CheckBox hasChip, EditText dateText, EditText typeText, ImageView image){
        ContentValues values = new ContentValues();

        values.put(DBStructure.COLUMN_NAME,nameText.getText().toString());
        values.put(DBStructure.COLUMN_AGE,ageText.getText().toString());
        values.put(DBStructure.COLUMN_CHIP,hasChip.isChecked());
        values.put(DBStructure.COLUMN_DATE,dateText.getText().toString());
        values.put(DBStructure.COLUMN_TYPE, typeText.getText().toString());
        //fata pasar imagen
        //Picasso.with(contxt).load(imageurl).placeholder(R.drawable.ic_launcher).into(imageview);
        //contentValues.put(DBStructure.COLUMN_IMAGE, image.get)
        return values;
    }

    public void createAnimal(ContentValues values){
        dbConnection.insert(DBStructure.TABLE_NAME,values);
    }


}
