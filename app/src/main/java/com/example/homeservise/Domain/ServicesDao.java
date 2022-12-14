package com.example.homeservise.Domain;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface ServicesDao {

    @Insert
    void insert(Services services);

    @Update
    void update(Services services);

    @Delete
    void delete(Services services);

    @Query("delete from services_table")
    void deleteAllservices();

    @Query("select * from services_table ")
    LiveData<List<Services>> getAllservices();

    @Query("select * from services_table where serCat='نظافة' ")
    LiveData<List<Services>> getAllCleanWorker();

        @Query("select * from services_table where serCat='ميكانيكا' ")
    LiveData<List<Services>> getAllMechanicalWorker();
        @Query("select * from services_table where serCat='سباكة' ")
    LiveData<List<Services>> getAllPlumberWorker();
        @Query("select * from services_table where serCat='كهرباء' ")
    LiveData<List<Services>> getAllElictricalWorker();
        @Query("select * from services_table where serCat='نجارة' ")
    LiveData<List<Services>> getAllCarpenterWorker();
        @Query("select * from services_table where serCat='غسيل' ")
    LiveData<List<Services>> getAllWachingWorker();
        @Query("select * from services_table where serCat='حدائق' ")
    LiveData<List<Services>> getAllGardenWorker();


}
