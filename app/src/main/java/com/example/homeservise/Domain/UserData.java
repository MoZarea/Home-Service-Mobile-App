package com.example.homeservise.Domain;

import androidx.room.Entity;

@Entity
public class UserData {
    int id;
    String name;
    String phone;
    String email;
    String favoriteID;
    int  wallet;
    String address;
}
