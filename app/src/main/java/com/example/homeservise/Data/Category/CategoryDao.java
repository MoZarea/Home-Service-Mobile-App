package com.example.homeservise.Data.Category;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CategoryDao {

    String clean="نظافة";

    @Insert
    void insert(Category category);

    @Update
    void update(Category category);

    @Delete
    void delete(Category category);

    @Query("delete from category_table")
    void deleteAllCategory();

    @Query("select * from category_table ")
    LiveData<List<Category>> getAllCategory();


}
