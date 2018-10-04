package com.animal.refugio.refugioanimales.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.animal.refugio.refugioanimales.R;
import com.animal.refugio.refugioanimales.persistance.DataSource;


public class MainActivity extends AppCompatActivity {

    DataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mDataSource = new DataSource(this);
        mDataSource.open();

        Toast.makeText(this,"Creada",Toast.LENGTH_SHORT);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mDataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDataSource.open();
    }
}
