package com.animal.refugio.refugioanimales.persistance;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.animal.refugio.refugioanimales.application.Controller.AnimalDTO;
import com.animal.refugio.refugioanimales.domain.Animal;

import java.util.List;

@Dao
public interface AnimalDao {

    //inserto una lista de animales
    @Insert
    void insertAll(List<Animal> animales);

    //inserto uno o más animales
    @Insert
    void insertAll(Animal... animales);

    @Query("SELECT * FROM animal ORDER BY date DESC")
    LiveData<List<AnimalDTO>> getAllOrderedByDateDesc();

    @Query("SELECT * FROM animal WHERE id = :id")
    Animal getAnimalById(Integer id);

    @Query("SELECT * FROM animal WHERE id = :id")
    AnimalDTO getAnimalDTOById(Integer id);

    @Delete
    void deleteAnimal (Animal... animal);

    @Update
    int updateAnimal (Animal animal);
}
