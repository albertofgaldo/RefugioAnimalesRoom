package com.animal.refugio.refugioanimales.application.Controller;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.media.ImageWriter;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.animal.refugio.refugioanimales.domain.Animal;
import com.animal.refugio.refugioanimales.persistance.DBController;
import com.animal.refugio.refugioanimales.persistance.DBRoom;
import com.animal.refugio.refugioanimales.view.ListActivity;

import java.io.ByteArrayOutputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AnimalController extends AndroidViewModel {

    private DBController dbController;
    private LiveData <List<AnimalDTO>> animalesDTO;
    Animal animal;

    public AnimalController(@NonNull Application application){
        super(application);
        dbController = new DBController(application);
        animalesDTO = dbController.getAnimales();
    }

    public void createAnimal(Animal animal) {
        dbController.insert(animal);
    }

    public void updateAnimal(Animal animal) {
        dbController.update(animal);
    }

    public void deleteAnimal(int id){
        dbController.delete(dbController.getAnimal(id));
    }

    public LiveData <List<AnimalDTO>> getAnimalesList() {
        return dbController.getAnimales();
    }

    public AnimalDTO getAnimal(int id){
        return dbController.getAnimalDTO(id);
    }

    public byte[] imageViewToByte (ImageView image){
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    public Animal mapFieldsToAnimal(EditText nameText, EditText ageText, CheckBox hasChip, EditText dateText, EditText typeText, ImageView image){
        animal = new Animal();
        animal.setName(nameText.getText().toString());
        animal.setAge(Integer.parseInt(ageText.getText().toString()));
        animal.setHasChip(hasChip.isChecked());
        animal.setDate(dateText.getText().toString());
        animal.setType(typeText.getText().toString());
        animal.setPicture(imageViewToByte(image));
        return animal;
    }
}
