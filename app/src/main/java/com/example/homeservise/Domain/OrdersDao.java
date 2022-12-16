package com.example.homeservise.Domain;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface OrdersDao {

    @Insert
    void insert(Oders oders);

    @Update
    void update(Oders oders);

    @Delete
    void delete(Oders oders);

    @Query("delete from Oders")
    void deleteAllOrders();

    @Query("select * from Oders ")
    LiveData<List<Oders>> getAllOders();

    @Query("select * from Oders where orderID=:id ")
    List<Oders> getOdersbyID(int id);

    @Query("select * from Oders  where serviceID=:serviceID ")
    List<Oders> getUserByEmail(int  serviceID);




}
