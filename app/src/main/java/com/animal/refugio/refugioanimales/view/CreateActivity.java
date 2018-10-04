package com.animal.refugio.refugioanimales.view;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.animal.refugio.refugioanimales.R;

public class CreateActivity extends AppCompatActivity {

    EditText nameText, ageText, dateText, typeText;
    CheckBox hasChip;
    ImageView image;
    Button save;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        nameText = (EditText)findViewById(R.id.editTextName);
        ageText = (EditText)findViewById(R.id.editTextAge);
        hasChip = (CheckBox)findViewById(R.id.checkBoxChip);
        dateText = (EditText)findViewById(R.id.editTextDate);
        typeText = (EditText)findViewById(R.id.editTextType);
        image = (ImageView) findViewById(R.id.imageViewPicture);
        save = (Button)findViewById(R.id.buttonSave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkFormCreate()){
                    //mapear los campos en una estructura
                }else {
                    Toast.makeText(CreateActivity.this, "Revisa los campos", Toast.LENGTH_SHORT);
                }
            }
        });

    }

    public boolean checkFormCreate(){
        if(nameText.getText().toString().isEmpty()){return false;}
        if(ageText.getText().toString().isEmpty()) {return false;}
        if(dateText.getText().toString().isEmpty()) {return false;}
        if(typeText.getText().toString().isEmpty()) {return false;}
        if(image.getDrawable()==null) {return false;}
        return true;
    }
}
