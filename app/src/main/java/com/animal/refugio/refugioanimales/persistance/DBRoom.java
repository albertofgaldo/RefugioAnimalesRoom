package com.animal.refugio.refugioanimales.persistance;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.animal.refugio.refugioanimales.domain.Animal;

@Database(entities = {Animal.class}, version = 1)
public abstract class DBRoom extends RoomDatabase {

    //declaro la instancia
    private static DBRoom instance;

    public abstract AnimalDao animalDao();

    //devuelvo la instancia de la BBDD, la creo si está vacía
    //synchronized se encarga de gestionar el acceso para que no se creen dos instancias en diferentes hilos
    public static synchronized DBRoom getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DBRoom.class, "animal_shelter.db")
                    .fallbackToDestructiveMigration() //permite hacer querys en el mainThread, normalmente se hacen en background
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private AnimalDao animalDao;

        private PopulateDbAsyncTask(DBRoom dbRoom){
            animalDao = dbRoom.animalDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            //animalDao.insertAll();
            return null;
        }
    }
    //destruye la instancia
    public static void destroyInstance(){
        instance=null;
    }
}
