package com.animal.refugio.refugioanimales.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.animal.refugio.refugioanimales.R;
import com.animal.refugio.refugioanimales.application.Controller.AnimalController;
import com.animal.refugio.refugioanimales.persistance.DataSource;


public class MainActivity extends AppCompatActivity {

  AnimalController animalController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

       //crear controller
        animalController = new AnimalController(this);
        //Toast.makeText(this,"Creada",Toast.LENGTH_SHORT);
    }

    @Override
    protected void onPause() {
        super.onPause();
        animalController.closeDataSource();
    }

    @Override
    protected void onResume() {
        super.onResume();
        animalController.closeDataSource();
    }
}
