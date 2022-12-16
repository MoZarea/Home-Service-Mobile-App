package com.example.homeservise.Domain;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(UserData userData);

    @Update
    void update(UserData userData);

    @Delete
    void delete(UserData userData);

    @Query("delete from userdata")
    void deleteAllUsers();

    @Query("select * from userdata ")
    LiveData<List<UserData>> getAllUsers();

    @Query("select * from userdata where id=1 ")
   LiveData< List<UserData>> getUserOne();

    @Query("select * from userdata  where email=:email ")
    List<UserData> getUserByEmail(String email);

    @Query("select * from userdata where phone=:phone ")
    LiveData<List<UserData>> getUserByPhone(String phone);

    @Query("select * from userdata where name=:name ")
    LiveData<List<UserData>> getUserByName(String name);


}
