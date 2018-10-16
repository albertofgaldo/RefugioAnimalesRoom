package com.animal.refugio.refugioanimales.view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.animal.refugio.refugioanimales.R;
import com.animal.refugio.refugioanimales.application.Controller.AnimalAdapter;
import com.animal.refugio.refugioanimales.application.Controller.AnimalController;
import com.animal.refugio.refugioanimales.application.Controller.AnimalDTO;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private AnimalController animalController;
    private AnimalDTO animalDTO;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final RecyclerView recyclerView = findViewById(R.id.recyclerId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final AnimalAdapter animalAdapter = new AnimalAdapter();
        recyclerView.setAdapter(animalAdapter);

        animalController = ViewModelProviders.of(this).get(AnimalController.class);
        animalController.getAnimalesList().observe(this, new Observer<List<AnimalDTO>>() {
            @Override
            public void onChanged(@Nullable List<AnimalDTO> animalesDTO) {
                //update RecyclerView
                animalAdapter.setAnimalesDTO(animalesDTO);
            }
        });
        //animalesDTO = animalController.getAnimalesList();
        animalAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListActivity.this,DetailActivity.class);
                i.putExtra("id",animalAdapter.getAnimalesDTO().get(recyclerView.getChildAdapterPosition(v)).getId());
                startActivity(i);
                //Toast.makeText(ListActivity.this, animalesDTO.get(recyclerView.getChildAdapterPosition(v)).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
