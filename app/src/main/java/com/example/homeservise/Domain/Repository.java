package com.example.homeservise.Domain;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public class Repository {

    //TODO اعمل باقي الجداول هنا
    private ServicesDao servicesDao;
    private CategoryDao categoryDao;

    public Repository(Application application) {
        //عملت instance
        RoomDatabases database = RoomDatabases.getDatabase(application);
        //اكسس على الDAO
        //TODO اعمل باقي الجداول هنا
        categoryDao = database.categoryDao();
        servicesDao = database.servicesDao();

    }

    ///////////////////////////////////////////////////////////////////////
    ///////////////////////category//////////////////////////
    //////////////////////////////////////////////////////////////////
    public void insert(Category category) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            categoryDao.insert(category);

        });

    }

    public void update(Category category) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            categoryDao.update(category);

        });

    }

    public void delete(Category category) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            categoryDao.delete(category);

        });

    }

    public void deleteAllCategory() {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            categoryDao.deleteAllCategory();
        });

    }

    public LiveData<List<Category>> getAllCategory() {
        return categoryDao.getAllCategory();
    }
////////////////////////////////////////////////////////
    ///////////////services//////////////////////
    ////////////////////////////////////////////////////
    public void insert(Services services) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            servicesDao.insert(services);

        });

    }

    public void update(Services services) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            servicesDao.update(services);

        });
    }

    public void delete(Services services) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            servicesDao.delete(services);

        });
    }

    public void deleteAllservices() {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            servicesDao.deleteAllservices();

        });
    }

    public LiveData<List<Services>> getAllservices() {
        return servicesDao.getAllservices();
    }

    public void getAllServicesByCat(String name,ServicesValueListener listener) {
        RoomDatabases.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                List<Services> services =servicesDao.getAllServicesByCat(name);
                listener.onValueSubmit(services);
            }
        });
    }
    public LiveData<List<Services>> getAllOffer() {return  servicesDao.getAllOffer();}

    public LiveData<List<Services>> getAllFavorute() {
        return servicesDao.getAllFavorute();
    }


}
