package com.animal.refugio.refugioanimales.application.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.media.ImageWriter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.animal.refugio.refugioanimales.domain.Animal;
import com.animal.refugio.refugioanimales.persistance.DBController;
import com.animal.refugio.refugioanimales.view.ListActivity;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class AnimalController {

    DBController dbController;

    public AnimalController(Context context){
        dbController = new DBController(context);
    }

    public void openConnection(){
        dbController.openConnection();
    }

    public void closeConnection(){
        dbController.closeConnection();
    }

    public void createAnimal(EditText nameText, EditText ageText, CheckBox hasChip, EditText dateText, EditText typeText, ImageView image){
        dbController.insertValues(nameText, ageText, hasChip, dateText, typeText, imageViewToByte(image));
    }

    public byte[] imageViewToByte (ImageView image){
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    public ArrayList<AnimalDTO> readAnimals() {
       return dbController.animalToArrayList();
    }
}
