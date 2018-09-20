package com.animal.refugio.refugioanimales.domain;

import android.graphics.Bitmap;
import com.animal.refugio.refugioanimales.utilities.Utils;

import java.util.Date;

public class Animal {

    private int id;
    private String name;
    private int age;
    private boolean hasChip;
    private Utils.kindAnimal kindAnimal;
    private Date date;
    private Bitmap picture;
    private static int counter=1;

    public Animal(String name, int age, boolean hasChip, Utils.kindAnimal kindAnimal, Date date, Bitmap picture ){
        this.id= counter;
        this.name = name;
        this.age = age;
        this.hasChip = hasChip;
        this.kindAnimal = kindAnimal;
        this.date = date;
        this.picture = picture;
        this.counter++;
    }

    public int getId(){ return this.id; }

    public String getName(){ return this.name; }

    public void setName(String name){ this.name = name; }

    public int getAge(){ return this.age; }

    public void setAge(int age){this.age = age;}

    public boolean getHasChip(){ return this.hasChip; }

    public void setHasChip(boolean hasChip){ this.hasChip=hasChip; }

    public Utils.kindAnimal getKindAnimal(){ return this.kindAnimal; }

    public void setKindAnimal(Utils.kindAnimal kindAnimal){this.kindAnimal = kindAnimal; }

    public Date getDate (){return date;}

    public void setDate (Date date){this.date=date;}

    public Bitmap getPicture(){ return this.picture;}

    public void setPicture(Bitmap picture){this.picture=picture;}


}
