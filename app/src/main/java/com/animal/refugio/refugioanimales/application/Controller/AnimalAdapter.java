package com.animal.refugio.refugioanimales.application.Controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.animal.refugio.refugioanimales.R;
import com.animal.refugio.refugioanimales.domain.Animal;
import com.animal.refugio.refugioanimales.utilities.ImageConverter;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolderAnimal> implements View.OnClickListener {

    private List<AnimalDTO> animalesDTO = new ArrayList<>();
    private View.OnClickListener listener;

    public AnimalAdapter(){}

    public AnimalAdapter(List<AnimalDTO> animalesDTO){
        this.animalesDTO = animalesDTO;
    }

    @NonNull
    @Override
    public ViewHolderAnimal onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_adapter_animal,viewGroup,false);
        view.setOnClickListener(this);
        return new ViewHolderAnimal(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAnimal viewHolderAnimal, int position) {
        viewHolderAnimal.linkData(animalesDTO.get(position));
    }

    @Override
    public int getItemCount() {
        return animalesDTO.size();
    }

    public void setAnimalesDTO(List<AnimalDTO> animalesDTO){
       this.animalesDTO = animalesDTO;
       notifyDataSetChanged();
    }

    public List<AnimalDTO> getAnimalesDTO(){return animalesDTO;}

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    class ViewHolderAnimal extends RecyclerView.ViewHolder {
        private TextView id, name,age, chip, type, date;
        private ImageView image;

        public ViewHolderAnimal(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textViewId);
            name = itemView.findViewById(R.id.textViewName);
            age = itemView.findViewById(R.id.textViewAge);
            chip = itemView.findViewById(R.id.textViewChip);
            type = itemView.findViewById(R.id.textViewType);
            date = itemView.findViewById(R.id.textViewDate);
            image = itemView.findViewById(R.id.imageView);
        }

        public void linkData(AnimalDTO animalDTO) {
            id.setText(Integer.toString(animalDTO.getId()));
            name.setText("Nombre: " + animalDTO.getName());
            age.setText("Edad: " + (Integer.toString(animalDTO.getAge())));
            chip.setText(hasChip(animalDTO.getHasChip()));
            type.setText("Tipo: " + animalDTO.getType());
            date.setText("Registro: " + animalDTO.getDate());
            ImageConverter imageConverter = new ImageConverter();
            image.setImageBitmap(imageConverter.byteToBmp(animalDTO.getPicture()));
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
    }
}

