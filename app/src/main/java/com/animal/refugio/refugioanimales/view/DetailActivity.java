package com.animal.refugio.refugioanimales.view;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.drawable.Drawable;
import android.icu.util.Calendar;
import android.icu.util.RangeValueIterator;
import android.icu.util.ValueIterator;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.animal.refugio.refugioanimales.R;
import com.animal.refugio.refugioanimales.application.Controller.AnimalController;
import com.animal.refugio.refugioanimales.application.Controller.AnimalDTO;
import com.animal.refugio.refugioanimales.utilities.ImageConverter;

import java.lang.annotation.ElementType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class DetailActivity extends AppCompatActivity {

    EditText nameText, ageText, dateText, typeText;
    CheckBox hasChip;
    ImageView image;
    Drawable oldDrawable;
    Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date;
    String dateFormat = "dd/MM/yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.GERMAN);
    Button edit, delete;
    AnimalController animalController;
    AnimalDTO animalDTO;
    Boolean editMode=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nameText = (EditText)findViewById(R.id.editTextName);
        ageText = (EditText)findViewById(R.id.editTextAge);
        hasChip = (CheckBox)findViewById(R.id.checkBoxChip);
        dateText = (EditText)findViewById(R.id.editTextDate);
        typeText = (EditText)findViewById(R.id.editTextType);
        image = (ImageView) findViewById(R.id.imageViewPicture);
        edit = (Button)findViewById(R.id.buttonSave);
        delete = (Button)findViewById(R.id.buttonDelete);
        //editMode=false;

        animalController = ViewModelProviders.of(this).get(AnimalController.class);
        animalDTO = animalController.getAnimal(getIntent().getExtras().getInt("id"));
        loadAnimalDTO(animalDTO);

        activeForm(false);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editMode){
                    edit.setText("Guardar");
                    editMode=true;
                    activeForm(true);
                    delete.setEnabled(false);
                }else{
                    if(checkFormCreate()) {
                        animalController.updateAnimal(animalController.mapFieldsToAnimal(nameText, ageText, hasChip, dateText, typeText, image));
                        edit.setText("Editar");
                        editMode=false;
                        activeForm(false);
                        delete.setEnabled(true);
                        Toast.makeText(DetailActivity.this, "Animal actualizado", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    private void activeForm(Boolean b){
        changeElement(nameText,b);
        changeElement(ageText,b);
        changeElement(dateText,b);
        changeElement(hasChip,b);
        changeElement(typeText,b);
    }
    private void changeElement(View element, boolean b) {
        element.setFocusable(b);
        element.setEnabled(b);
    }

    private void loadAnimalDTO(AnimalDTO animalDTO){
        nameText.setText(animalDTO.getName());
        ageText.setText((Integer.toString(animalDTO.getAge())));
        hasChip.setChecked(animalDTO.getHasChip());
        dateText.setText(animalDTO.getDate());
        typeText.setText(animalDTO.getType());
        ImageConverter imageConverter = new ImageConverter();
        image.setImageBitmap(imageConverter.byteToBmp(animalDTO.getPicture()));
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
        return true;
    }
}
