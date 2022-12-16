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

    @Query("select * from services_table where serCat=:CatName ")
    List<Services> getAllServicesByCat(String CatName);

    @Query("select * from services_table  where is_Offer=1 ")
    LiveData<List<Services>> getAllOffer();

    @Query("select * from services_table where is_favorite=1 ")
    LiveData<List<Services>> getAllFavorute();


    @Query("select * from services_table where id=:id")
    Services get_ser_by_id(int id);




}
