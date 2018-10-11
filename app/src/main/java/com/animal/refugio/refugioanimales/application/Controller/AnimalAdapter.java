package com.animal.refugio.refugioanimales.application.Controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.animal.refugio.refugioanimales.R;

import java.util.ArrayList;

public class AnimalAdapter extends ArrayAdapter {

    Activity context;
    ArrayList<AnimalDTO> animalDTO;
    TextView id, name,age, chip, type, date;
    ImageView image;

    public AnimalAdapter(Activity context, ArrayList<AnimalDTO> animalDTO){
        super (context, R.layout.activity_adapter_animal,animalDTO);
        this.context = context;
        this.animalDTO = animalDTO;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.activity_adapter_animal,null);

        id = item.findViewById(R.id.textViewId);
        name = item.findViewById(R.id.textViewName);
        age = item.findViewById(R.id.textViewAge);
        chip = item.findViewById(R.id.textViewChip);
        type = item.findViewById(R.id.textViewType);
        date = item.findViewById(R.id.textViewDate);
        image = item.findViewById(R.id.imageView);

        id.setText(Integer.toString(animalDTO.get(position).getId()));
        name.setText("Nombre: " + animalDTO.get(position).getName());
        age.setText("Edad: " + (Integer.toString(animalDTO.get(position).getAge())));
        chip.setText(hasChip(animalDTO.get(position).getHasChip()));
        type.setText("Tipo: " + animalDTO.get(position).getKindAnimal());
        date.setText("Registro: " + animalDTO.get(position).getDate());
        image.setImageBitmap(animalDTO.get(position).getPicture());

        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return item;
    }

    public String hasChip(Boolean hasChip){
        if(hasChip){
            name.setTextColor(Color.BLUE);
            name.setTypeface(null, Typeface.BOLD);
            return "Tiene chip";
        }
        name.setTextColor(Color.DKGRAY);
        name.setTypeface(null, Typeface.NORMAL);
        return "No tiene chip";
    }

    private static class ViewHolder {
       // public TextView text;
        public Button button;

        public ViewHolder(Button btn) {
           // text = tv;
          //  button = btn;
            button.setOnClickListener(mMyLocalClickListener);
        }

        private View.OnClickListener mMyLocalClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }
}

