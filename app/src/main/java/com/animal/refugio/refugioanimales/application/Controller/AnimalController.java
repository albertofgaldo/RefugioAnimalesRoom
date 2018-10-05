package com.animal.refugio.refugioanimales.application.Controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.media.Image;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.animal.refugio.refugioanimales.R;
import com.animal.refugio.refugioanimales.persistance.DataSource;
import com.animal.refugio.refugioanimales.persistance.ItemsTable;
import com.squareup.picasso.Picasso;

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

    public ContentValues mapFields(EditText nameText, EditText ageText, CheckBox hasChip, EditText dateText, EditText typeText, ImageView image){
        ContentValues contentValues = new ContentValues();

        contentValues.put(ItemsTable.COLUMN_NAME,nameText.getText().toString());
        contentValues.put(ItemsTable.COLUMN_AGE,ageText.getText().toString());
        contentValues.put(ItemsTable.COLUMN_CHIP,hasChip.isChecked());
        contentValues.put(ItemsTable.COLUMN_DATE,dateText.getText().toString());
        contentValues.put(ItemsTable.COLUMN_TYPE, typeText.getText().toString());
        //fata pasar imagen
        //Picasso.with(contxt).load(imageurl).placeholder(R.drawable.ic_launcher).into(imageview);
        //contentValues.put(ItemsTable.COLUMN_IMAGE, image.get)

        return contentValues;
    }

    public void createAnimal(ContentValues contentValues){

        
    }


}
