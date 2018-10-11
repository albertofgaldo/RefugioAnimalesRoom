package com.animal.refugio.refugioanimales.application.Controller;

import android.graphics.Bitmap;
import android.media.Image;

import java.util.Date;

public class AnimalDTO {
    private int id;
    private String name;
    private int age;
    private boolean hasChip;
    private String type;
    private String date;
    private Bitmap picture;

    public AnimalDTO(){};

    public AnimalDTO(String name, int age, boolean hasChip, String type, String date, Bitmap picture ){

        this.name = name;
        this.age = age;
        this.hasChip = hasChip;
        this.type = type;
        this.date = date;
        this.picture = picture;
    }

    public int getId(){ return this.id; }

    public void setId(int id){this.id=id;}

    public String getName(){ return this.name; }

    public void setName(String name){ this.name = name; }

    public int getAge(){ return this.age; }

    public void setAge(int age){this.age = age;}

    public boolean getHasChip(){ return this.hasChip; }

    public void setHasChip(boolean hasChip){ this.hasChip=hasChip; }

    public String getKindAnimal(){ return this.type; }

    public void setKindAnimal(String type){this.type = type; }

    public String getDate (){return date;}

    public void setDate (String date){this.date=date;}

    public Bitmap getPicture(){ return this.picture;}

    public void setPicture(Bitmap picture){this.picture=picture;}
}
