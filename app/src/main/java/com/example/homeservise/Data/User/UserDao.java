package com.example.homeservise.Data.User;

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
    UserData getUserByEmail(String email);

    @Query("select * from userdata where phone=:phone ")
    UserData getUserByPhone(String phone);

    @Query("select * from userdata where UID=:id ")
    LiveData<UserData> getUserByUID(String id);


}
