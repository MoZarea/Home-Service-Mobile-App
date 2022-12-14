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
    //TODO  اعمل باقي القيم الراجعه

    LiveData<List<Category>> allCategory;
    LiveData<List<Services>> allServices;
    LiveData<List<Services>> AllCleanWorker;
    LiveData<List<Services>> AllMechanicalWorker;
    LiveData<List<Services>> AllPlumberWorker;
    LiveData<List<Services>> AllElictricalWorker;
    LiveData<List<Services>> AllCarpenterWorker;
    LiveData<List<Services>> AllWachingWorker;
    LiveData<List<Services>> AllGardenWorker;

    public Repository(Application application) {
        //عملت instance
        RoomDatabases database = RoomDatabases.getDatabase(application);
        //اكسس على الDAO
        //TODO اعمل باقي الجداول هنا
        categoryDao = database.categoryDao();
        servicesDao = database.servicesDao();
        //ثم  نجيب اي قيمه بترجع حاجه هنا الاول وبعدين نعمل الداله بتاعتها تحت
        //TODO  اعمل باقي القيم الراجعه
        allCategory = categoryDao.getAllCategory();
        allServices = servicesDao.getAllservices();
        AllCleanWorker = servicesDao.getAllCleanWorker();

        AllMechanicalWorker = servicesDao.getAllMechanicalWorker();
        AllPlumberWorker = servicesDao.getAllPlumberWorker();
        AllElictricalWorker = servicesDao.getAllElictricalWorker();
        AllCarpenterWorker = servicesDao.getAllCarpenterWorker();
        AllWachingWorker = servicesDao.getAllWachingWorker();
        AllGardenWorker = servicesDao.getAllGardenWorker();

    }

    ///////////////////////////////////////////////////////////////////////
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
        return allCategory;
    }

    ///////////////////////////////////////////////////////////////////////////////////
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
        return allServices;
    }

    public LiveData<List<Services>> getAllCleanWorker() {
        return AllCleanWorker;
    }

    public LiveData<List<Services>> getAllMechanicalWorker() {
        return AllMechanicalWorker;
    }

    public LiveData<List<Services>> getAllPlumberWorker() {
        return AllPlumberWorker;
    }

    public LiveData<List<Services>> getAllElictricalWorker() {
        return AllElictricalWorker;
    }

    public LiveData<List<Services>> getAllCarpenterWorker() {
        return AllCarpenterWorker;
    }

    public LiveData<List<Services>> getAllWachingWorker() {
        return AllWachingWorker;
    }

    public LiveData<List<Services>> getAllGardenWorker() {
        return AllGardenWorker;
    }

}
