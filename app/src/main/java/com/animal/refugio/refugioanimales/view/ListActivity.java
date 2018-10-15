package com.animal.refugio.refugioanimales.view;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.animal.refugio.refugioanimales.R;
import com.animal.refugio.refugioanimales.application.Controller.AnimalAdapter;
import com.animal.refugio.refugioanimales.application.Controller.AnimalController;
import com.animal.refugio.refugioanimales.application.Controller.AnimalDTO;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    AnimalController animalController;
    ListView listView;
    ArrayList<AnimalDTO> animales;
    ArrayAdapter<AnimalDTO> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listViewAnimales);
        animalController = new AnimalController(ListActivity.this);
        animales = new ArrayList<>(animalController.getAnimalesList());
        adapter = new AnimalAdapter(ListActivity.this,animales);
        listView.setAdapter(adapter);
    }
}
