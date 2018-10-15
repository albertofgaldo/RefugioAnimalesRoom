package com.animal.refugio.refugioanimales.persistance;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.animal.refugio.refugioanimales.domain.Animal;

@Database(entities = {Animal.class}, version = 1)
public abstract class DBRoom extends RoomDatabase {

    //declaro la instancia
    private static DBRoom instance;

    public abstract AnimalDao animalDao();

    //devuelvo la instancia de la BBDD, la creo si está vacía
    public static DBRoom getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DBRoom.class, "animal_shelter.db")
                    .allowMainThreadQueries() //permite hacer querys en el mainThread, normalmente se hacen en background
                    .build();
        }
        return instance;
    }

    //destruye la instancia
    public static void destroyInstance(){
        instance=null;
    }
}
