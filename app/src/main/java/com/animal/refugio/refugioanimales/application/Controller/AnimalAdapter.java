package com.animal.refugio.refugioanimales.application.Controller;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.animal.refugio.refugioanimales.R;

import java.util.ArrayList;

public class AnimalAdapter extends ArrayAdapter {

    Activity context;
    ArrayList<AnimalDTO> animalDTO;

    public AnimalAdapter(Activity context, ArrayList<AnimalDTO> animalDTO){
        super (context, R.layout.activity_adapter_animal,animalDTO);
        this.context = context;
        this.animalDTO = animalDTO;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.activity_adapter_animal,null);

        TextView name = item.findViewById(R.id.textViewName);
        TextView age = item.findViewById(R.id.textViewAge);
        TextView chip = item.findViewById(R.id.textViewChip);
        TextView type = item.findViewById(R.id.textViewType);
        TextView date = item.findViewById(R.id.textViewDate);
        ImageView image = item.findViewById(R.id.imageView);

        name.setText(animalDTO.get(position).getName());
        age.setText((Integer.toString(animalDTO.get(position).getAge())));
        chip.setText(hasChip(animalDTO.get(position).getHasChip()));
        type.setText(animalDTO.get(position).getKindAnimal());
        date.setText(animalDTO.get(position).getDate());
        image.setImageBitmap(animalDTO.get(position).getPicture());

        return item;
    }

    public String hasChip(Boolean hasChip){
        if(hasChip){
            return "Tiene chip";
        }
        return "No tiene chip";
    }
}
