package com.example.homeservise.Data.Order;

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
    void insert(Orders oders);

    @Update
    void update(Orders oders);

    @Delete
    void delete(Orders oders);

    @Query("delete from Orders")
    void deleteAllOrders();

    @Query("select * from Orders ")
    LiveData<List<Orders>> getAllOders();

    @Query("select * from Orders where orderID=:id ")
    List<Orders> getOdersbyID(int id);

    @Query("select * from Orders  where serviceID=:serviceID ")
    List<Orders> getUserByEmail(int  serviceID);




}
