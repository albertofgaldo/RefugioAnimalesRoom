package com.animal.refugio.refugioanimales.view;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.animal.refugio.refugioanimales.R;
import com.animal.refugio.refugioanimales.persistance.BBDD_Structure;
import com.animal.refugio.refugioanimales.utilities.ShowMessage;


public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        SQLiteOpenHelper dbHelper = new BBDD_Structure(this);
        database = dbHelper.getWritableDatabase();
        Toast.makeText(this,"Creada",Toast.LENGTH_SHORT);
        //ShowMessage showMessage = new ShowMessage();
       // showMessage.setMessage(this,"BBDD creada");
    }
}
