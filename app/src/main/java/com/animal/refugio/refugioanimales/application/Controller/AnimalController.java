package com.animal.refugio.refugioanimales.application.Controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.animal.refugio.refugioanimales.domain.Animal;
import com.animal.refugio.refugioanimales.persistance.DBController;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AnimalController {

    //DBConnection dbConnection;
    DBController dbController;

    Context context;

    public AnimalController(Context context){
        this.context = context;
        dbController = new DBController(context);
    }

    public void openConnection(){
        dbController.openConnection();
    }

    public void closeConnection(){
        dbController.closeConnection();
    }

    public void createAnimal(EditText nameText, EditText ageText, CheckBox hasChip, EditText dateText, EditText typeText, ImageView image){
        //Animal animal = new Animal(nameText.toString(), (Integer.parseInt(ageText.toString())),hasChip.isActivated(),typeText.toString(),dateText.toString(),image);
        dbController.insertValues(nameText, ageText, hasChip, dateText, typeText, imageViewToByte(image));
    }

    public byte[] imageViewToByte (ImageView image){
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

}
