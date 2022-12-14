package com.example.homeservise.Domain;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.homeservise.R;

@Entity(tableName = "category_table")
public class Category {
    @PrimaryKey (autoGenerate = true)
    private int id;
    private String titel;
    private int pic;

    public Category(String titel, int pic) {
        this.titel = titel;
        this.pic = pic;
    }

    public String getTitel() {
        return titel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPic() {
        return pic;
    }

    public int getId() {
        return id;
    }



}
