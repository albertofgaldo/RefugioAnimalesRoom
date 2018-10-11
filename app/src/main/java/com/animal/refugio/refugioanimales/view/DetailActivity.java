package com.animal.refugio.refugioanimales.view;

import android.app.DatePickerDialog;
import android.graphics.drawable.Drawable;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.animal.refugio.refugioanimales.R;
import com.animal.refugio.refugioanimales.application.Controller.AnimalController;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_detail);

        disableEditText(nameText);
        disableEditText(ageText);
        disableEditText(dateText);
    }
    private void disableEditText(EditText editText) {
        editText.setFocusable(false);
        editText.setEnabled(false);
        editText.setCursorVisible(false);
        editText.setKeyListener(null);
        //editText.setBackgroundColor(Color.TRANSPARENT);
    }
}
