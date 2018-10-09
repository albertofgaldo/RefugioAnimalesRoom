package com.animal.refugio.refugioanimales.view;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.animal.refugio.refugioanimales.R;
import com.animal.refugio.refugioanimales.application.Controller.AnimalController;
import com.animal.refugio.refugioanimales.application.Controller.AnimalDTO;
import com.animal.refugio.refugioanimales.persistance.DBController;

public class ListActivity extends AppCompatActivity {

    AnimalController animalController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        for (AnimalDTO animalDTO:animalController.readAnimals()) {
            //mostrar elementos en el listView
        }

    }
}
