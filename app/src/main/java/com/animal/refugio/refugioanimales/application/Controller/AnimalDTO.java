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
    private long date;
    private byte[] picture;

    public AnimalDTO(){};

    public AnimalDTO(String name, int age, boolean hasChip, String type, long date, byte[] picture ){

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

    public String getType(){ return this.type; }

    public void setType(String type){this.type = type; }

    public long getDate (){return date;}

    public void setDate (long date){this.date=date;}

    public byte[] getPicture(){ return this.picture;}

    public void setPicture(byte[] picture){this.picture=picture;}
}
