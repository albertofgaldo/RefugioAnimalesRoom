package com.animal.refugio.refugioanimales.view;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.animal.refugio.refugioanimales.R;
import com.animal.refugio.refugioanimales.application.Controller.AnimalController;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class CreateActivity extends AppCompatActivity {

    EditText nameText, ageText, dateText, typeText;
    CheckBox hasChip;
    ImageView image;
    Drawable oldDrawable;
    Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date;
    String dateFormat = "dd/MM/yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.GERMAN);
    Button save;
    AnimalController animalController;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int PICK_IMAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        nameText = (EditText)findViewById(R.id.editTextName);
        ageText = (EditText)findViewById(R.id.editTextAge);
        hasChip = (CheckBox)findViewById(R.id.checkBoxChip);
        dateText = (EditText)findViewById(R.id.editTextDate);
        typeText = (EditText)findViewById(R.id.editTextType);
        image = (ImageView) findViewById(R.id.imageViewPicture);
        save = (Button)findViewById(R.id.buttonSave);
        oldDrawable = image.getDrawable();

        animalController = new AnimalController(this);

        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDate();
            }
        };

        dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CreateActivity.this, date, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkFormCreate()) {
                    animalController.createAnimal(nameText, ageText, hasChip, dateText, typeText, image);
                    Toast.makeText(CreateActivity.this, "Animal creado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        });
    }

    private void updateDate() {
        dateText.setText(sdf.format(calendar.getTime()));
    }

    public void takePicture(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == REQUEST_IMAGE_CAPTURE){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(photo);
        }else if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            //imageUri = data.getData();
            image.setImageURI(data.getData());
        }
    }

    public boolean checkFormCreate(){
        if(nameText.getText().toString().isEmpty()){
            Toast.makeText(this,"Nombre incorrecto",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(ageText.getText().toString().isEmpty()) {
            Toast.makeText(this,"Edad incorrecta",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(dateText.getText().toString().isEmpty()) {
            Toast.makeText(this,"Fecha incorrecta",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(typeText.getText().toString().isEmpty()) {
            Toast.makeText(this,"Tipo incorrecto",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(image.getDrawable()==oldDrawable) {
            Toast.makeText(this,"Imagen incorrecta",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
