package com.animal.refugio.refugioanimales.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.animal.refugio.refugioanimales.R;
import com.animal.refugio.refugioanimales.application.Controller.AnimalController;


public class MainActivity extends AppCompatActivity {

    Button listButton, createButton;
    AnimalController animalController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        listButton = (Button)findViewById(R.id.buttonList);
        createButton = (Button)findViewById(R.id.buttonCreate);

        animalController = new AnimalController(this);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animalController.closeConnection();
                Intent create = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(create);
            }
        });

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animalController.closeConnection();
                Intent list = new Intent(MainActivity.this, ListActivity.class);
                startActivity(list);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        animalController.closeConnection();
    }

    @Override
    protected void onResume() {
        super.onResume();
        animalController.openConnection();
    }


}
