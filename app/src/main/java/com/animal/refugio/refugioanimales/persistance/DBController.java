package com.animal.refugio.refugioanimales.persistance;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.animal.refugio.refugioanimales.application.Controller.AnimalDTO;
import com.animal.refugio.refugioanimales.domain.Animal;

import java.util.List;

public class DBController {

    private AnimalDao animalDao;
    LiveData<List<AnimalDTO>> animalesDTO;

    public DBController(Application application){
        DBRoom dbRoom = DBRoom.getInstance(application);
        animalDao = dbRoom.animalDao();
        animalesDTO = animalDao.getAllOrderedByDateDesc();
    }

    public void closeConnection(){
        DBRoom.destroyInstance();
    }

    public void insert(Animal animal){
        new InsertAnimalAsyncTask(animalDao).execute(animal);
    }

    public void delete(Animal animal){
        new DeleteAnimalAsyncTask(animalDao).execute(animal);
    }

    public void update(Animal animal){
        new UpdateAnimalAsyncTask(animalDao).execute(animal);
    }

    public LiveData<List<AnimalDTO>> getAnimales(){
        return animalesDTO;
    }

    public Animal getAnimal(int id){
        return animalDao.getAnimalById(id);
    }

    public AnimalDTO getAnimalDTO(int id){
        return animalDao.getAnimalDTOById(id);
    }

    //creamos una clase para insertar animales asíncronamente (necesario para LiveData)
    private static class InsertAnimalAsyncTask extends AsyncTask<Animal,Void, Void>{
        private AnimalDao animalDao;
        private InsertAnimalAsyncTask(AnimalDao animalDao){
            this.animalDao = animalDao;
        }

        @Override
        protected Void doInBackground(Animal... animals) {
            animalDao.insertAll(animals[0]);
            return null;
        }
    }
    //creamos una clase para borrar animales asíncronamente (necesario para LiveData)
    private static class DeleteAnimalAsyncTask extends AsyncTask<Animal,Void, Void>{
        private AnimalDao animalDao;
        private DeleteAnimalAsyncTask(AnimalDao animalDao){
            this.animalDao = animalDao;
        }

        @Override
        protected Void doInBackground(Animal... animals) {
            animalDao.deleteAnimal(animals[0]);
            return null;
        }
    }
    //creamos una clase para actualizar animales asíncronamente (necesario para LiveData)
    private static class UpdateAnimalAsyncTask extends AsyncTask<Animal,Void, Void>{
        private AnimalDao animalDao;
        private UpdateAnimalAsyncTask(AnimalDao animalDao){
            this.animalDao = animalDao;
        }

        @Override
        protected Void doInBackground(Animal... animals) {
            animalDao.updateAnimal(animals[0]);
            return null;
        }
    }
}

