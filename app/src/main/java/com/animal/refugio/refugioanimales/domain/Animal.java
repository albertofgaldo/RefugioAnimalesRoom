package com.animal.refugio.refugioanimales.domain;
import com.animal.refugio.refugioanimales.utilities.*;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

@Entity
public class Animal implements Parcelable {

    @PrimaryKey (autoGenerate = true)
    private int id;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private int age;
    @ColumnInfo
    private boolean hasChip;
    @ColumnInfo
    private String type;
    @ColumnInfo
    @TypeConverters(DateTypeConverter.class)
    private String date;
    @ColumnInfo
    private byte[] picture;
    @ColumnInfo()
    private static int counter=1;

    public Animal(){}

    public Animal(String name, int age, boolean hasChip, String type, String date, byte[] picture ){
        this.id= counter;
        this.name = name;
        this.age = age;
        this.hasChip = hasChip;
        this.type = type;
        this.date = date;
        this.picture = picture;
        this.counter++;
    }

    protected Animal(Parcel in) {
        id = in.readInt();
        name = in.readString();
        age = in.readInt();
        hasChip = in.readByte() != 0;
        type = in.readString();
        date = in.readString();
        picture = in.createByteArray();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public int getId(){ return this.id; }

    public void setId(int id){this.id = id;}

    public String getName(){ return this.name; }

    public void setName(String name){ this.name = name; }

    public int getAge(){ return this.age; }

    public void setAge(int age){this.age = age;}

    public boolean getHasChip(){ return this.hasChip; }

    public void setHasChip(boolean hasChip){ this.hasChip=hasChip; }

    public String getType(){ return this.type; }

    public void setType(String type){this.type = type; }

    public String getDate (){return date;}

    public void setDate (String date){this.date=date;}

    public byte[] getPicture(){ return this.picture;}

    public void setPicture(byte[] picture){this.picture=picture;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.age);
        dest.writeValue(this.hasChip);
        dest.writeString(this.date);
        dest.writeByteArray(this.picture);
    }
}
